package com.softsquared.template.kotlin.src.trip.cityhome

import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.TOUR_KEY
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.WEATHER_KEY
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentVisitBinding
import com.softsquared.template.kotlin.src.trip.cityhome.tmodel.TourList
import com.softsquared.template.kotlin.src.trip.triptool.TripToolService

data class Tour(val name : String?, val intro : String?, val where : String?, val photo : String?, var checked : Boolean)

class VisitFragment : BaseFragment<FragmentVisitBinding>(FragmentVisitBinding::bind, R.layout.fragment_visit), VisitFragmentInterface{
    private lateinit var lvAdapter: VisitAdapter
    private val tourData = arrayListOf<Tour>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        VisitService(this).tryGetTourData(TOUR_KEY, "kr","",1,"")
        val footer = layoutInflater.inflate(R.layout.item_footer_list, null, false)
        lvAdapter = VisitAdapter(requireContext(), tourData)
        binding.lvTour.addFooterView(footer)
        binding.lvTour.adapter = lvAdapter
    }

    override fun onGetTourDataSuccess(response: TourList) {
        var n = response.resultCount
        var t_name: String? = ""
        var t_intro: String? = ""
        var t_where: String? = ""
        var t_photo: String? = ""
        for(i in 0 until n){
            try {
                t_where = response.items[i].region1cd.label +" "+ response.items[i].region2cd.label
                t_name = response.items[i].title
                t_intro = response.items[i].introduction
                t_photo = response.items[i].repPhoto.photoid.imgpath
                tourData.add(Tour(t_name, t_intro, t_where, t_photo,false))
            }catch (e:NullPointerException){
                continue
            }

        }
        lvAdapter.notifyDataSetChanged()
    }

    override fun onGetTourDataFailure(message: String) {
        Log.d("VisitFragment",  "통신오류")
    }

}