package com.softsquared.template.kotlin.src.date

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import java.util.*

import androidx.core.view.isVisible
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityDateBinding
import com.softsquared.template.kotlin.util.MinMaxDecorator
import com.softsquared.template.kotlin.util.SaturdayDecorator
import com.softsquared.template.kotlin.util.SundayDecorator
import java.text.SimpleDateFormat



class DateActivity : BaseActivity<ActivityDateBinding>(ActivityDateBinding::inflate) {
    private var startTimeCalendar = Calendar.getInstance()
    private var endTimeCalendar = Calendar.getInstance()

    private val currentYear = startTimeCalendar.get(Calendar.YEAR)
    private val currentMonth = startTimeCalendar.get(Calendar.MONTH)
    private val currentDate = startTimeCalendar.get(Calendar.DATE)
    private var year :Int = 0
    private var month :Int = 0
    private var day :Int = 0
    //private var cDate = 0
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        endTimeCalendar.set(Calendar.MONTH, currentMonth+11)
        val stCalendarDay = CalendarDay(currentYear, currentMonth, currentDate)
        val enCalendarDay = CalendarDay(endTimeCalendar.get(Calendar.YEAR),endTimeCalendar.get(Calendar.MONTH), endTimeCalendar.get(Calendar.DATE))
        val sundayDecorator = SundayDecorator()
        val saturdayDecorator = SaturdayDecorator()
        val minMaxDecorator = MinMaxDecorator(stCalendarDay, enCalendarDay)

        binding.cvDate.state().edit()
            .setMinimumDate(
                CalendarDay.from(
                    getCurrentYear(),
                    getCurrentMonth(),
                    1
                )
            )
            .setMaximumDate(CalendarDay.from(getCurrentYear() + 1,getCurrentMonth()+11,30))
            .setCalendarDisplayMode(CalendarMode.MONTHS)
            .commit()
        binding.cvDate.addDecorators(sundayDecorator, saturdayDecorator, minMaxDecorator)

        binding.cvDate.setOnDateChangedListener { widget, date, selected ->
            year = date.year
            month = date.month
            day = date.day
            binding.btDateSelect.isVisible = true
            binding.btDateSelect.text = "$year.$month.$day / 선택완료"
        }

        binding.btDateSelect.setOnClickListener {
            val intent = Intent()
            val date : String = "$year$month$day"
            intent.putExtra("Date", date)
            setResult(RESULT_OK, intent)
            finish()
        }

        setContentView(binding.root)
    }
    private fun getCurrentYear(): Int = Calendar.getInstance().get(Calendar.YEAR)

    private fun getCurrentMonth(): Int = Calendar.getInstance().get(Calendar.MONTH)

    fun getCurrentDay(): Int = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

    fun convertDateToTimestamp(_year: Int, _month: Int, _day: Int): Long {
        val month = _month.toString().convertSingleToDoubleDigit().toInt()
        val day = _day.toString().convertSingleToDoubleDigit().toInt()
        val date = "$_year-$month+1-$day"
        return date.convertDateToTimestamp()
    }
    private fun String.convertSingleToDoubleDigit(): String = if (this.length < 2) "0$this" else this

    private fun String.convertDateToTimestamp(): Long =
        SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).parse(this).time
}