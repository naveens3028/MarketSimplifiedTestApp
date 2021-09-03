package com.example.marketsimplifiedtestapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marketsimplifiedtestapp.R
import com.example.marketsimplifiedtestapp.activity.DetailsActivity
import com.example.marketsimplifiedtestapp.database.model.MyData
import com.google.android.material.card.MaterialCardView


class DashBoardDataAdapter(
    val context: Context,
    private val chaptersList: List<MyData>,
) :
    RecyclerView.Adapter<DashBoardDataAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardData = itemView.findViewById(R.id.cardData) as MaterialCardView
        val imgData = itemView.findViewById(R.id.imgData) as AppCompatImageView
        val nameTxt = itemView.findViewById(R.id.nameTxt) as AppCompatTextView
        val nodeTxt = itemView.findViewById(R.id.nodeTxt) as AppCompatTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_recycler, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = chaptersList[position]
        //By using glide, we can avoid using bitmap cache holders,
        //As Glide default behaviour is the same as caching once loaded all the images
        //No need to load again
        Glide.with(context)
            .load(data.owner?.avatarUrl)
            .into(holder.imgData)
        holder.nameTxt.text = "Name: " + data.name
        holder.nodeTxt.setText("Node Id: " + data.nodeId)

        holder.cardData.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("id", data.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return chaptersList.size
    }
}