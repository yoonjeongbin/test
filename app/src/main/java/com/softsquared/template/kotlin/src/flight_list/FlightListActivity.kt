package com.softsquared.template.kotlin.src.flight_list

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.FLIGHT_KEY
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityFlightListBinding
import com.softsquared.template.kotlin.src.flight_list.fmodel.FlightList
import com.softsquared.template.kotlin.util.CustomDecoration

data class flightData(val logo: Int, val time_start: String, val time_end: String, val go: String, val arrive: String,
    val name: String, val howlong: String, val price: String)
data class Header(val h_date:String, val h_count : String)

class FlightListActivity : BaseActivity<ActivityFlightListBinding>(ActivityFlightListBinding::inflate),FlightListActivityInterface{
    private var f_logo = 0
    private var f_time_start = ""
    private var f_time_end = ""
    private var f_go = ""
    private var f_arrive = ""
    private var f_name = ""
    private var f_howlong = ""
    //private var f_price = ""
    private lateinit var rvAdapter: FlightAdapter
    private val dataSet = arrayListOf<flightData>()
    //private val h_dataSet = arrayListOf<Header>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val goData = intent.getStringExtra("goData")
        val arriveData = intent.getStringExtra("arriveData")
        val dateData = intent.getStringExtra("dateData")
        var date2 = dateData?.toInt()
        //TripToolService(this).tryGetWeather(33.4624,126.54039,"minutely", ApplicationClass.WEATHER_KEY )
        //FlightListService(this).tryFlightListData(FLIGHT_KEY, 60, 1, "NAARKJJ", "NAARKPC", 20201227, "")
        if (goData == "서울") {
            when (arriveData) {
                "제주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKSS", "NAARKPC", date2, "")
                    }
                }
                "부산" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKSS", "NAARKPK", date2, "")
                    }
                }
                "광주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKSS", "NAARKJJ", date2, "")
                    }
                }
                "청주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKSS", "NAARKTU", date2, "")
                    }
                }
                "대구" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKSS", "NAARKTN", date2, "")
                    }
                }
                "여수" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKSS", "NAARKJY", date2, "")
                    }
                }
                "양양" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKSS", "NAARKNY", date2, "")
                    }
                }
                "포항" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKSS", "NAARKTH", date2, "")
                    }
                }
            }
        } else if (goData == "제주") {
            when (arriveData) {
                "서울" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPC", "NAARKSS", date2, "")
                    }
                }
                "부산" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPC", "NAARKPK", date2, "")
                    }
                }
                "광주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPC", "NAARKJJ", date2, "")
                    }
                }
                "청주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPC", "NAARKTU", date2, "")
                    }
                }
                "대구" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPC", "NAARKTN", date2, "")
                    }
                }
                "여수" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPC", "NAARKJY", date2, "")
                    }
                }
                "양양" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPC", "NAARKNY", date2, "")
                    }
                }
                "포항" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPC", "NAARKTH", date2, "")
                    }
                }
            }
        } else if (goData == "부산") {
            when (arriveData) {
                "서울" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPK", "NAARKSS", date2, "")
                    }
                }
                "제주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPK", "NAARKPC", date2, "")
                    }
                }
                "광주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPK", "NAARKJJ", date2, "")
                    }
                }
                "청주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPK", "NAARKTU", date2, "")
                    }
                }
                "대구" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPK", "NAARKTN", date2, "")
                    }
                }
                "여수" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPK", "NAARKJY", date2, "")
                    }
                }
                "양양" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPK", "NAARKNY", date2, "")
                    }
                }
                "포항" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKPK", "NAARKTH", date2, "")
                    }
                }
            }
        } else if (goData == "광주") {
            when (arriveData) {
                "서울" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJJ", "NAARKSS", date2, "")
                    }
                }
                "제주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJJ", "NAARKPC", date2, "")
                    }
                }
                "부산" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJJ", "NAARKPK", date2, "")
                    }
                }
                "청주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJJ", "NAARKTU", date2, "")
                    }
                }
                "대구" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJJ", "NAARKTN", date2, "")
                    }
                }
                "여수" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJJ", "NAARKJY", date2, "")
                    }
                }
                "양양" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJJ", "NAARKNY", date2, "")
                    }
                }
                "포항" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJJ", "NAARKTH", date2, "")
                    }
                }
            }
        } else if (goData == "청주") {
            when (arriveData) {
                "서울" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTU", "NAARKSS", date2, "")
                    }
                }
                "제주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTU", "NAARKPC", date2, "")
                    }
                }
                "부산" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTU", "NAARKPK", date2, "")
                    }
                }
                "광주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTU", "NAARKJJ", date2, "")
                    }
                }
                "대구" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTU", "NAARKTN", date2, "")
                    }
                }
                "여수" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTU", "NAARKJY", date2, "")
                    }
                }
                "양양" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTU", "NAARKNY", date2, "")
                    }
                }
                "포항" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTU", "NAARKTH", date2, "")
                    }
                }
            }
        } else if (goData == "대구") {
            when (arriveData) {
                "서울" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTN", "NAARKSS", date2, "")
                    }
                }
                "제주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTN", "NAARKPC", date2, "")
                    }
                }
                "부산" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTN", "NAARKPK", date2, "")
                    }
                }
                "광주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTN", "NAARKJJ", date2, "")
                    }
                }
                "청주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTN", "NAARKTU", date2, "")
                    }
                }
                "여수" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTN", "NAARKJY", date2, "")
                    }
                }
                "양양" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTN", "NAARKNY", date2, "")
                    }
                }
                "포항" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTN", "NAARKTH", date2, "")
                    }
                }
            }
        } else if (goData == "여수") {
            when (arriveData) {
                "서울" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJY", "NAARKSS", date2, "")
                    }
                }
                "제주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJY", "NAARKPC", date2, "")
                    }
                }
                "부산" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJY", "NAARKPK", date2, "")
                    }
                }
                "광주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJY", "NAARKJJ", date2, "")
                    }
                }
                "청주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJY", "NAARKTU", date2, "")
                    }
                }
                "대구" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJY", "NAARKTN", date2, "")
                    }
                }
                "양양" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJY", "NAARKNY", date2, "")
                    }
                }
                "포항" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKJY", "NAARKTH", date2, "")
                    }
                }
            }
        } else if (goData == "양양") {
            when (arriveData) {
                "서울" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKNY", "NAARKSS", date2, "")
                    }
                }
                "제주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKNY", "NAARKPC", date2, "")
                    }
                }
                "부산" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKNY", "NAARKPK", date2, "")
                    }
                }
                "광주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKNY", "NAARKJJ", date2, "")
                    }
                }
                "청주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKNY", "NAARKTU", date2, "")
                    }
                }
                "대구" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKNY", "NAARKTN", date2, "")
                    }
                }
                "여수" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKNY", "NAARKJY", date2, "")
                    }
                }
                "포항" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKNY", "NAARKTH", date2, "")
                    }
                }
            }
        } else if (goData == "포항") {
            when (arriveData) {
                "서울" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTH", "NAARKSS", date2, "")
                    }
                }
                "제주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTH", "NAARKPC", date2, "")
                    }
                }
                "부산" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTH", "NAARKPK", date2, "")
                    }
                }
                "광주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTH", "NAARKJJ", date2, "")
                    }
                }
                "청주" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTH", "NAARKTU", date2, "")
                    }
                }
                "대구" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTH", "NAARKTN", date2, "")
                    }
                }
                "여수" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTH", "NAARKJY", date2, "")
                    }
                }
                "양양" -> {
                    if (date2 != null) {
                        FlightListService(this).tryFlightListData(FLIGHT_KEY, 200, 1, "NAARKTH", "NAARKNY", date2, "")
                    }
                }
            }
        }
        rvAdapter = FlightAdapter(dataSet)
        binding.rvFl.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvFl.adapter = rvAdapter
        val dividerItemDecoration = DividerItemDecoration(applicationContext, LinearLayoutManager(this).orientation)
        val customDecoration = CustomDecoration(25f, 0f, 0xFFFAFAFA)
        binding.rvFl.addItemDecoration(customDecoration)

    }

    override fun onGetFlightListSuccess(response: FlightList) {
        var n = response.response.body.totalCount
        //var headerDate = goDate.toString()
        // headerDate = headerDate.substring(4,6) + "." + headerDate.substring(6,8)
        //h_dataSet.add(Header(headerDate,n.toString()+"개"))
        //binding.btFlDate.text = result.response.body.items.item[0].depAirportNm
        for (i in 0 until n) {

            var f_price = response.response.body.items.item[i].economyCharge.toString() + "원"

            //f_price = f_price.substring(0,2) + "," + f_price.substring(2,5) + "원"

            when(response.response.body.items.item[i].depAirportNm){
                "김포" -> {f_go = "GMP"}
                "제주" -> {f_go = "CJU"}
                "김해" -> {f_go = "PUS"}
                "광주" -> {f_go = "KWJ"}
                "청주" -> {f_go = "CJJ"}
                "대구" -> {f_go = "TAE"}
                "여수" -> {f_go = "RSU"}
                "양양" -> {f_go = "YNY"}
                "포항" -> {f_go = "KPO"}
            }
            when(response.response.body.items.item[i].arrAirportNm){
                "김포" -> {f_arrive = "GMP"}
                "제주" -> {f_arrive = "CJU"}
                "김해" -> {f_arrive = "PUS"}
                "광주" -> {f_arrive = "KWJ"}
                "청주" -> {f_arrive = "CJJ"}
                "대구" -> {f_arrive = "TAE"}
                "여수" -> {f_arrive = "RSU"}
                "양양" -> {f_arrive = "YNY"}
                "포항" -> {f_arrive = "KPO"}
            }

            when(response.response.body.items.item[i].airlineNm){
                "대한항공" -> {
                    f_logo = R.drawable.ic_deahan_air
                    f_name = "대한항공"
                }
                "에어서울" -> {
                    f_logo = R.drawable.ic_air_seoul
                    f_name = "에어서울"
                }
                "에어부산" -> {
                    f_logo = R.drawable.ic_air_busan
                    f_name = "에어부산"
                }
                "티웨이항공" -> {
                    f_logo = R.drawable.ic_tway
                    f_name = "티웨이항공"
                }
                "진에어" -> {
                    f_logo = R.drawable.ic_jin_air
                    f_name = "진에어"
                }
                "제주항공" -> {
                    f_logo = R.drawable.ic_jeju_air
                    f_name = "제주항공"
                }
                "이스타항공" -> {
                    f_logo = R.drawable.ic_jeju_air
                    f_name = "제주항공"
                }
            }
            var string1 = response.response.body.items.item[i].depPlandTime.toString()
            var string2 = response.response.body.items.item[i].arrPlandTime.toString()
            string1 = string1.substring(8,10) + ":" + string1.substring(10,12)
            string2 = string2.substring(8,10) + ":" + string2.substring(10,12)
            //f_time_start = "06:55"
            //f_time_end = "07:55"
            //f_howlong = "직항 1시간"

            dataSet.add(flightData(f_logo, string1, string2, f_go,
                f_arrive, f_name, "직항 1시간 15분", f_price))
        }
        rvAdapter.notifyDataSetChanged()
    }

    override fun onGetFlightListFailure(message: String) {
        TODO("Not yet implemented")
    }
}