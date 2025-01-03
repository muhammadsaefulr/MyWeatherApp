package com.example.weatherappeg.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappeg.Domain.Forecast7Day
import com.example.weatherappeg.R

class ForecastAdapter(
    private val forecastList: ArrayList<Forecast7Day>,
    private val context: Context
) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(context).inflate(R.layout.viewholder_forecast_7days, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val forecasts = forecastList[position]

        holder.forecastDate.text = forecasts.DateInfo
        holder.dayName.text = forecasts.DayName
        holder.forecastTempTxt.text = "${forecasts.temp}°C"
        holder.weatherPic.setImageResource(forecasts.picImgPath)
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val forecastDate: TextView = itemView.findViewById(R.id.forecastDate)
        val dayName: TextView = itemView.findViewById(R.id.forecastDayName)
        val forecastTempTxt: TextView = itemView.findViewById(R.id.forecastTemp)
        val weatherPic: ImageView = itemView.findViewById(R.id.forecastPicWeather)
    }
}