package com.franlops.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.franlops.conf.R
import com.franlops.conf.model.Speaker

class SpeakerApapter(val speakerListener: SpeakerListener): RecyclerView.Adapter<SpeakerApapter.ViewHolder>() {

    var listSpeakers = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SpeakerApapter.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_speaker, parent, false
        )
    )

    override fun getItemCount() = listSpeakers.size

    override fun onBindViewHolder(holder: SpeakerApapter.ViewHolder, position: Int) {
        val speaker = listSpeakers[position]
        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerWork.text = speaker.workplace
        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivSpeakerImage)

        holder.itemView.setOnClickListener { speakerListener.onSpeakerClicked(speaker, position) }
    }

    fun updateData(data: List<Speaker>){
        listSpeakers.clear()
        listSpeakers.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvSpeakerWork = itemView.findViewById<TextView>(R.id.tvItemSpeakerWork)
        val ivSpeakerImage = itemView.findViewById<ImageView>(R.id.ivItemSepakerImage)

    }

}