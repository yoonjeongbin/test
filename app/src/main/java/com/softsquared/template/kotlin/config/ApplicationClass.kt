package com.softsquared.template.kotlin.config

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// 앱이 실행될때 1번만 실행이 됩니다.
class ApplicationClass : Application() {
    val API_URL = "https://members.softsquared.com/"
    val WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/"
    val VISIT_API_URL = "http://api.visitjeju.net/vsjApi/contents/"
    val FLIGHT_LIST_URL = "http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/"

    // 테스트 서버 주소
    // val API_URL = "http://dev-api.test.com/"

    // 실 서버 주소
    // val API_URL = "http://api.test.com/"

    // 코틀린의 전역변수 문법
    companion object {
        // 만들어져있는 SharedPreferences 를 사용해야합니다. 재생성하지 않도록 유념해주세요
        lateinit var sSharedPreferences: SharedPreferences

        // JWT Token Header 키 값
        val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"
        val WEATHER_KEY = "45f932fd7c76ec5414b5c8ec204ea5cf"
        val TOUR_KEY = "wdhkh5dw5ev6cvg3"
        val FLIGHT_KEY = "iOsSg7SsQnn9oHGqbJo2A73DilcpwmIyKVrnq0puly4WPZgmww7UzNhpFisZn32fvFS2dCXuXE9kiu9I4L0kgg=="

        // Retrofit 인스턴스, 앱 실행시 한번만 생성하여 사용합니다.
        lateinit var sRetrofit: Retrofit

        lateinit var wRetrofit: Retrofit

        lateinit var vRetrofit: Retrofit

        lateinit var fRetrofit: Retrofit
    }

    // 앱이 처음 생성되는 순간, SP를 새로 만들어주고, 레트로핏 인스턴스를 생성합니다.
    override fun onCreate() {
        super.onCreate()
        sSharedPreferences =
            applicationContext.getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        // 레트로핏 인스턴스 생성
        initRetrofitInstance()
    }

    // 레트로핏 인스턴스를 생성하고, 레트로핏에 각종 설정값들을 지정해줍니다.
    // 연결 타임아웃시간은 5초로 지정이 되어있고, HttpLoggingInterceptor를 붙여서 어떤 요청이 나가고 들어오는지를 보여줍니다.
    private fun initRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줍니다.
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()

        // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson을 넣어주고 빌드해주는 코드
        // 이 전역변수로 http 요청을 서버로 보내면 됩니다.
        sRetrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        wRetrofit = Retrofit.Builder()
            .baseUrl(WEATHER_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        vRetrofit = Retrofit.Builder()
            .baseUrl(VISIT_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fRetrofit = Retrofit.Builder()
            .baseUrl(FLIGHT_LIST_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}