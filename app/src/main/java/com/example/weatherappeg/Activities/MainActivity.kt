package com.example.weatherappeg.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappeg.Adapter.HourlyAdapter
import com.example.weatherappeg.Domain.Hourly
import com.example.weatherappeg.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val hourlyData = ArrayList<Hourly>()

        hourlyData.add(Hourly("10:00 AM", 22, R.drawable.cloudy_sunny))
        hourlyData.add(Hourly("13:00 AM", 24, R.drawable.sunny))
        hourlyData.add(Hourly("15:00 AM", 19, R.drawable.rainy))
        hourlyData.add(Hourly("18:00 AM", 24, R.drawable.cloudy_sunny))

        val adapter = HourlyAdapter(hourlyData, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        val BtnNavigateToForecast: Button = findViewById(R.id.navigate_toForecast)
        BtnNavigateToForecast.setOnClickListener {
            val intent = Intent(this, DayForecastActivity::class.java)
            startActivity(intent)
        }

    }
}