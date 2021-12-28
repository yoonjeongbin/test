package com.softsquared.template.kotlin.src.flight

import android.content.Intent
import android.os.Bundle
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityFlightBinding
import com.softsquared.template.kotlin.src.arrive.ArriveActivity
import com.softsquared.template.kotlin.src.date.DateActivity
import com.softsquared.template.kotlin.src.flight_list.FlightListActivity
import com.softsquared.template.kotlin.src.go.GoActivity

class FlightActivity : BaseActivity<ActivityFlightBinding>(ActivityFlightBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.chipOne.setOnClickListener {
            binding.chipTwo.isChecked = false
            if(binding.chipOne.isChecked){
                binding.chipOne.setChipBackgroundColorResource(R.color.backBlue)
                binding.chipOne.setTextAppearanceResource(R.style.ChipTextStyle)
            }
            else{
                binding.chipOne.setChipBackgroundColorResource(R.color.white)
                binding.chipOne.setTextAppearanceResource(R.style.ChipTextStyleN)
            }
            if(binding.chipTwo.isChecked){
                binding.chipTwo.setChipBackgroundColorResource(R.color.backBlue)
                binding.chipTwo.setTextAppearanceResource(R.style.ChipTextStyle)
            }
            else{
                binding.chipTwo.setChipBackgroundColorResource(R.color.white)
                binding.chipTwo.setTextAppearanceResource(R.style.ChipTextStyleN)
            }


        }
        binding.chipTwo.setOnClickListener {
            binding.chipOne.isChecked = false

            if(binding.chipOne.isChecked){
                binding.chipOne.setChipBackgroundColorResource(R.color.backBlue)
                binding.chipOne.setTextAppearanceResource(R.style.ChipTextStyle)
            }
            else{
                binding.chipOne.setChipBackgroundColorResource(R.color.white)
                binding.chipOne.setTextAppearanceResource(R.style.ChipTextStyleN)
            }
            if(binding.chipTwo.isChecked){
                binding.chipTwo.setChipBackgroundColorResource(R.color.backBlue)
                binding.chipTwo.setTextAppearanceResource(R.style.ChipTextStyle)
            }
            else{
                binding.chipTwo.setChipBackgroundColorResource(R.color.white)
                binding.chipTwo.setTextAppearanceResource(R.style.ChipTextStyleN)
            }

        }

        binding.tvSelectGoLocation.setOnClickListener {
            val intent = Intent(this, GoActivity::class.java)
            startActivityForResult(intent,1234)
        }
        binding.tvSelectArriveLocation.setOnClickListener {
            val intent = Intent(this, ArriveActivity::class.java)
            startActivityForResult(intent,5678)
        }
        binding.tvSelectDate.setOnClickListener {
            val intent = Intent(this, DateActivity::class.java)
            startActivityForResult(intent,9101)
        }

        binding.ibSelectChange.setOnClickListener {
            var change = binding.tvSelectGoLocation.text.toString()
            binding.tvSelectGoLocation.text = binding.tvSelectArriveLocation.text.toString()
            binding.tvSelectArriveLocation.text = change
        }

        binding.btSearchFlight.setOnClickListener {
            val goData: String = binding.tvSelectGoLocation.text.toString()
            val arriveData: String = binding.tvSelectArriveLocation.text.toString()
            val dateData: String = binding.tvSelectDate.text.toString()

            val intent = Intent(this, FlightListActivity::class.java)
            intent.putExtra("goData",goData)
            intent.putExtra("arriveData",arriveData)
            intent.putExtra("dateData",dateData)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        if(binding.tvSelectArriveLocation.text != "" && binding.tvSelectDate.text != "" && binding.tvSelectGoLocation.text
            != "" && binding.tvSelectNum.text != ""){
            binding.btSearchFlight.isEnabled = true
            binding.btSearchFlight.setBackgroundResource(R.drawable.select_flight_stroke2)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1234 && resultCode == RESULT_OK) {
            val gData = data?.getStringExtra("Go")
            binding.tvSelectGoLocation.text = gData
        }
        if (requestCode == 5678 && resultCode == RESULT_OK) {
            val aData = data?.getStringExtra("Arrive")
            binding.tvSelectArriveLocation.text = aData
        }
        if (requestCode == 9101 && resultCode == RESULT_OK) {
            val dData = data?.getStringExtra("Date")
            binding.tvSelectDate.text = dData
        }
    }

}