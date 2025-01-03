package com.example.weatherappeg.Activities
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappeg.Adapter.ForecastAdapter
import com.example.weatherappeg.Domain.Forecast7Day
import com.example.weatherappeg.R

class DayForecastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.day_forecast)

        var BackButton: ImageButton = findViewById(R.id.back_icon)

        BackButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val recyclerView: RecyclerView = findViewById(R.id.forecastRecylerView)
        val forecastData = ArrayList<Forecast7Day>()

        forecastData.add(Forecast7Day(34, "Senen", "06 March 2024", R.drawable.sunny))
        forecastData.add(Forecast7Day(26, "Selasa", "07 March 2024", R.drawable.sunny))
        forecastData.add(Forecast7Day(24, "Rabu", "08 March 2024", R.drawable.rainy))
        forecastData.add(Forecast7Day(30, "Kamis", "09 March 2024", R.drawable.rain))
        forecastData.add(Forecast7Day(26, "Jumat", "10 March 2024", R.drawable.rain))

        val adapter = ForecastAdapter(forecastData, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}