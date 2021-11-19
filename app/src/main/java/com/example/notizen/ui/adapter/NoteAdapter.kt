package com.example.notizen.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notizen.R
import com.example.notizen.data.model.Note
import com.example.notizen.ui.fragments.ListFragmentDirections
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter(
    private val notes: List<Note>
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private val TAG = "NoteAdapter"

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) 
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentItem = notes[position]
        Log.d(TAG, "onBindViewHolder: $currentItem")
        holder.itemView.tv_note_id.text = currentItem.id.toString()
        holder.itemView.tv_note_name.text = currentItem.name
        holder.itemView.tv_note_description.text = currentItem.description
//
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment()
            holder.itemView.findNavController().navigate(action)
        }
    }
}