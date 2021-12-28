package com.softsquared.template.kotlin.src.trip.triptool

import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.WEATHER_KEY
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentTripToolBinding
import com.softsquared.template.kotlin.src.trip.triptool.model.WeatherResponse
import java.text.SimpleDateFormat
import java.util.*

class TripToolFragment : BaseFragment<FragmentTripToolBinding>(FragmentTripToolBinding::bind, R.layout.fragment_trip_tool),
    TripToolFragmentInterface{
    private val longNow = System.currentTimeMillis()
    private val Cal : Calendar = Calendar.getInstance()
    private val tDate = Date(longNow)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TripToolService(this).tryGetWeather(33.4624,126.54039,"minutely",WEATHER_KEY)
        val tDateFormat = SimpleDateFormat("MM.dd", Locale("ko", "KR"))
        val strDate = tDateFormat.format(tDate)
        binding.tvTodayDate.text = strDate.toString()
        val hour = (Cal.get(Calendar.HOUR) + 1).toString()
        val hour2 = (Cal.get(Calendar.HOUR) + 2).toString()
        val hour3 = (Cal.get(Calendar.HOUR) + 3).toString()

        if(hour.toInt() < 10){
            binding.tvCurrentTime2.text = "0$hour:00"
        }
        else{
            binding.tvCurrentTime2.text = "$hour:00"
        }
        if(hour2.toInt() < 10){
            binding.tvCurrentTime3.text = "0$hour2:00"
        }
        else{
            binding.tvCurrentTime3.text = "$hour:00"
        }
        if(hour3.toInt() < 10){
            binding.tvCurrentTime4.text = "0$hour3:00"
        }
        else{
            binding.tvCurrentTime4.text = "$hour:00"
        }

        val month = (Cal.get(Calendar.MONTH)+1).toString()
        val day = (Cal.get(Calendar.DATE)+1).toString()
        binding.tvTomorrowDate.text = " $month.$day"
        val month2 = (Cal.get(Calendar.MONTH)+1).toString()
        val day2 = (Cal.get(Calendar.DATE)+2).toString()
        binding.tvTomorrowDate2.text = " $month2.$day2"
        val month3 = (Cal.get(Calendar.MONTH)+1).toString()
        val day3 = (Cal.get(Calendar.DATE)+3).toString()
        binding.tvTomorrowDate3.text = " $month3.$day3"
        val month4 = (Cal.get(Calendar.MONTH)+1).toString()
        val day4 = (Cal.get(Calendar.DATE)+4).toString()
        binding.tvTomorrowDate4.text = " $month4.$day4"
        val month5 = (Cal.get(Calendar.MONTH)+1).toString()
        val day5 = (Cal.get(Calendar.DATE)+5).toString()
        binding.tvTomorrowDate5.text = " $month5.$day5"

        binding.tvTomorrow2.text = doDayOfWeek(0).toString()
        binding.tvTomorrow3.text = doDayOfWeek(1).toString()
        binding.tvTomorrow4.text = doDayOfWeek(2).toString()
        binding.tvTomorrow5.text = doDayOfWeek(3).toString()
    }

    override fun onGetWeatherSuccess(response: WeatherResponse) {
        binding.tvSubsi.text = (response.current.temp - 273.15).toInt().toString() + "°"
        binding.tvCurrentTemp.text = (response.current.temp - 273.15).toInt().toString() + "°"

        when (response.current.weather[0].main) {
            "Clouds" -> {
                binding.tvWeatherAbout.text = " 구름많음"
                binding.ivCurrentWeatherIcon.setImageResource(R.drawable.ic_cloud)
            }
            "Clear" -> {
                binding.tvWeatherAbout.text = " 맑음"
                binding.ivCurrentWeatherIcon.setImageResource(R.drawable.ic_sun)
            }
            "Rain" -> {
                binding.tvWeatherAbout.text = " 비"
                binding.ivCurrentWeatherIcon.setImageResource(R.drawable.ic_rain)

            }
            "Snow" -> {
                binding.tvWeatherAbout.text = " 눈"
                binding.ivCurrentWeatherIcon.setImageResource(R.drawable.ic_snow)
            }
        }

        binding.tvMaxTemp.text = (response.daily[0].temp.min - 273.15).toInt().toString() + "°"
        binding.tvMinTemp.text = (response.daily[0].temp.max - 273.15).toInt().toString() + "°"

        binding.tvMaxTemp2.text = (response.daily[1].temp.min - 273.15).toInt().toString() + "°"
        binding.tvMinTemp2.text = (response.daily[1].temp.max - 273.15).toInt().toString() + "°"

        binding.tvMaxTemp3.text = (response.daily[2].temp.min - 273.15).toInt().toString() + "°"
        binding.tvMinTemp3.text = (response.daily[2].temp.max - 273.15).toInt().toString() + "°"

        binding.tvMaxTemp4.text = (response.daily[3].temp.min - 273.15).toInt().toString() + "°"
        binding.tvMinTemp4.text = (response.daily[3].temp.max - 273.15).toInt().toString() + "°"

        binding.tvMaxTemp5.text = (response.daily[4].temp.min - 273.15).toInt().toString() + "°"
        binding.tvMinTemp5.text = (response.daily[4].temp.max - 273.15).toInt().toString() + "°"

        when (response.daily[1].weather[0].main) {
            "Clouds" -> {
                binding.ivTomorrowWeatherIcon.setImageResource(R.drawable.small_ic_cloud)
            }
            "Clear" -> {
                binding.ivTomorrowWeatherIcon.setImageResource(R.drawable.small_ic_sun)
            }
            "Rain" -> {
                binding.ivTomorrowWeatherIcon.setImageResource(R.drawable.small_ic_rain)

            }
            "Snow" -> {
                binding.ivTomorrowWeatherIcon.setImageResource(R.drawable.small_ic_snow)
            }
        }
        when (response.daily[2].weather[0].main) {
            "Clouds" -> {
                binding.ivTomorrowWeatherIcon2.setImageResource(R.drawable.small_ic_cloud)
            }
            "Clear" -> {
                binding.ivTomorrowWeatherIcon2.setImageResource(R.drawable.small_ic_sun)
            }
            "Rain" -> {
                binding.ivTomorrowWeatherIcon2.setImageResource(R.drawable.small_ic_rain)

            }
            "Snow" -> {
                binding.ivTomorrowWeatherIcon2.setImageResource(R.drawable.small_ic_snow)
            }
        }
        when (response.daily[3].weather[0].main) {
            "Clouds" -> {
                binding.ivTomorrowWeatherIcon3.setImageResource(R.drawable.small_ic_cloud)
            }
            "Clear" -> {
                binding.ivTomorrowWeatherIcon3.setImageResource(R.drawable.small_ic_sun)
            }
            "Rain" -> {
                binding.ivTomorrowWeatherIcon3.setImageResource(R.drawable.small_ic_rain)

            }
            "Snow" -> {
                binding.ivTomorrowWeatherIcon3.setImageResource(R.drawable.small_ic_snow)
            }
        }
        when (response.daily[4].weather[0].main) {
            "Clouds" -> {
                binding.ivTomorrowWeatherIcon4.setImageResource(R.drawable.small_ic_cloud)
            }
            "Clear" -> {
                binding.ivTomorrowWeatherIcon4.setImageResource(R.drawable.small_ic_sun)
            }
            "Rain" -> {
                binding.ivTomorrowWeatherIcon4.setImageResource(R.drawable.small_ic_rain)

            }
            "Snow" -> {
                binding.ivTomorrowWeatherIcon4.setImageResource(R.drawable.small_ic_snow)
            }
        }
        when (response.daily[5].weather[0].main) {
            "Clouds" -> {
                binding.ivTomorrowWeatherIcon5.setImageResource(R.drawable.small_ic_cloud)
            }
            "Clear" -> {
                binding.ivTomorrowWeatherIcon5.setImageResource(R.drawable.small_ic_sun)
            }
            "Rain" -> {
                binding.ivTomorrowWeatherIcon5.setImageResource(R.drawable.small_ic_rain)

            }
            "Snow" -> {
                binding.ivTomorrowWeatherIcon5.setImageResource(R.drawable.small_ic_snow)
            }
        }

        when (response.hourly[1].weather[0].main) {
            "Clouds" -> {
                binding.ivCurrentWeatherIcon2.setImageResource(R.drawable.ic_cloud)
            }
            "Clear" -> {
                binding.ivCurrentWeatherIcon2.setImageResource(R.drawable.ic_sun)
            }
            "Rain" -> {
                binding.ivCurrentWeatherIcon2.setImageResource(R.drawable.ic_rain)

            }
            "Snow" -> {
                binding.ivCurrentWeatherIcon2.setImageResource(R.drawable.ic_snow)
            }
        }
        binding.tvCurrentTemp2.text = (response.hourly[1].temp - 273.15).toInt().toString() + "°"

        when (response.hourly[2].weather[0].main) {
            "Clouds" -> {
                binding.ivCurrentWeatherIcon3.setImageResource(R.drawable.ic_cloud)
            }
            "Clear" -> {
                binding.ivCurrentWeatherIcon3.setImageResource(R.drawable.ic_sun)
            }
            "Rain" -> {
                binding.ivCurrentWeatherIcon3.setImageResource(R.drawable.ic_rain)
            }
            "Snow" -> {
                binding.ivCurrentWeatherIcon3.setImageResource(R.drawable.ic_snow)
            }
        }
        binding.tvCurrentTemp3.text = (response.hourly[2].temp - 273.15).toInt().toString() + "°"

        when (response.hourly[3].weather[0].main) {
            "Clouds" -> {
                binding.ivCurrentWeatherIcon4.setImageResource(R.drawable.ic_cloud)
            }
            "Clear" -> {
                binding.ivCurrentWeatherIcon4.setImageResource(R.drawable.ic_sun)
            }
            "Rain" -> {
                binding.ivCurrentWeatherIcon4.setImageResource(R.drawable.ic_rain)
            }
            "Snow" -> {
                binding.ivCurrentWeatherIcon4.setImageResource(R.drawable.ic_snow)
            }
        }
        binding.tvCurrentTemp4.text = (response.hourly[3].temp - 273.15).toInt().toString() + "°"
    }

    override fun onGetWeatherFailure(message: String) {
        Log.d("TripToolFragment",  "통신오류")
    }
    private fun doDayOfWeek(n :Int): String? {
        val cal : Calendar = Calendar.getInstance()
        var strWeek :String? = null

        var nWeek = (cal.get(Calendar.DAY_OF_WEEK)+n)
        when(nWeek%7){
            0 -> {
                strWeek = "일"
            }
            1 -> {
                strWeek = "월"
            }
            2 -> {
                strWeek = "화"
            }
            3 -> {
                strWeek = "수"
            }
            4 -> {
                strWeek = "목"
            }
            5 -> {
                strWeek = "금"
            }
            6 -> {
                strWeek = "토"
            }
        }
        return strWeek
    }
}