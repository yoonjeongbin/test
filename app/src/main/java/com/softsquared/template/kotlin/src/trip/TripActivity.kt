package com.softsquared.template.kotlin.src.trip

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityTripBinding
import com.softsquared.template.kotlin.src.trip.cityhome.CityHomeFragment
import com.softsquared.template.kotlin.src.trip.cityhome.VisitFragment
import com.softsquared.template.kotlin.src.trip.plan.PlanFragment
import com.softsquared.template.kotlin.src.trip.save.SaveFragment
import com.softsquared.template.kotlin.src.trip.triptool.TripToolFragment

class TripActivity : BaseActivity<ActivityTripBinding>(ActivityTripBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().add(R.id.fl_fragment, CityHomeFragment()).commit()

        binding.bnvTrip.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.trip_menu_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_fragment, CityHomeFragment()).commitAllowingStateLoss()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.trip_menu_plan -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_fragment, PlanFragment()).commitAllowingStateLoss()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.trip_menu_tool -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_fragment, TripToolFragment()).commitAllowingStateLoss()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.trip_menu_save -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_fragment, SaveFragment()).commitAllowingStateLoss()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }
    fun onFragmentChange(index:Int){
        when(index){
            1 -> {supportFragmentManager.beginTransaction()
                .replace(R.id.fl_fragment, VisitFragment()).commit()}
            //2 -> {supportFragmentManager.beginTransaction()
               // .replace(R.id.fl_fragment, MapFragment()).commit()}
        }
    }
}