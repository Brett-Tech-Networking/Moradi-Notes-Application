package com.moradi.moradi_notes_premium.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moradi.moradi_notes_premium.R
import com.moradi.moradi_notes_premium.entities.Notes
import com.moradi.moradi_notes_premium.database.NotesDatabase
import kotlinx.android.synthetic.main.item_rv_notes.view.*

class NotesAdapter (val arrList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_notes, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.itemView.tvTitle.text = arrList[position].title
        holder.itemView.tvDesc.text = arrList[position].noteText
        holder.itemView.tvDateTime1.text = arrList[position].dateTime
    }


    class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}