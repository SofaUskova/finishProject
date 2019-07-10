package com.example.finishproject.adapters

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.finishproject.ItemTrack
import android.view.LayoutInflater
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.finishproject.OnFragmentInteractionListener
import com.example.finishproject.OnSelectedItemListener
import com.example.finishproject.R

class TracksAdapter(
    private val tracks: List<ItemTrack>,
    private val mOnSelectedItemListener: OnSelectedItemListener
) : RecyclerView.Adapter<TracksAdapter.ViewHolder>() {
    private var mOnFragmentInteractionListener: OnFragmentInteractionListener? = null

    interface OnItemClickListener {
        fun onItemClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_track, parent, false)
//        context = view.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return this.tracks.size
    }

    override fun onBindViewHolder(holder: TracksAdapter.ViewHolder, position: Int) {
        holder.date.text = tracks[position].dateTime
        holder.timeStart.text = tracks[position].timeStart
        holder.distance.text = tracks[position].distance
        holder.joggingTime.text = tracks[position].joggingTime

        holder.cardView.setOnClickListener {
            mOnSelectedItemListener.onSelectedItem(position)
        }
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal val date: TextView = view.findViewById(R.id.date)
        internal val timeStart: TextView = view.findViewById(R.id.time_start)
        internal val distance: TextView = view.findViewById(R.id.distance)
        internal val joggingTime: TextView = view.findViewById(R.id.jogging_time)
        internal val cardView: CardView = view.findViewById(R.id.cardView)
    }

}