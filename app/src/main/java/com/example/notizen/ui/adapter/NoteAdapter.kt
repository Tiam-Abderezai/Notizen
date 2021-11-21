package com.example.notizen.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notizen.R
import com.example.notizen.model.data.Note
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
        val item = notes[position]
        Log.d(TAG, "onBindViewHolder: $item")
        holder.itemView.chk_completed.isChecked = true
        holder.itemView.tv_title.text = item.title
        holder.itemView.tv_description.text = item.description
        holder.itemView.tv_createdAt.text = item.createdAt.toString()
        holder.itemView.tv_updatedAt.text = item.updatedAt.toString()
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(item)
            holder.itemView.findNavController().navigate(action)
        }

    }
}