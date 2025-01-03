package com.example.weatherappeg.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappeg.Domain.Hourly
import com.example.weatherappeg.R

class HourlyAdapter(
    private val hourlyList: ArrayList<Hourly>,
    private val context: Context
) : RecyclerView.Adapter<HourlyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.viewholder_hourly, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hourly = hourlyList[position]
        holder.hourlyTxt.text = hourly.hour
        holder.celciusTxt.text = "${hourly.temp}°C"
        holder.weatherPic.setImageResource(hourly.picImgPath)
    }

    override fun getItemCount(): Int {
        return hourlyList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hourlyTxt: TextView = itemView.findViewById(R.id.hourlyTxt)
        val celciusTxt: TextView = itemView.findViewById(R.id.celciusTxt)
        val weatherPic: ImageView = itemView.findViewById(R.id.weatherPic)
    }
}
