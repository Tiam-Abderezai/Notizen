package com.example.notizen.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notizen.R
import com.example.notizen.model.data.Note
import com.example.notizen.model.local.LocalRepo
import com.example.notizen.ui.fragments.ListFragmentDirections
import com.example.notizen.viewmodel.LocalViewModel
import kotlinx.android.synthetic.main.note_item.view.*
import java.text.SimpleDateFormat
import java.util.*

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
        holder.itemView.apply {
            id = position

            chk_completed.setOnCheckedChangeListener { buttonView, isChecked ->
                item.completed = isChecked

            }
            chk_completed.isChecked = item.completed
            tv_title.text = item.title
            tv_description.text = item.description
            tv_createdAt.text = "Created: ${getDate(item.createdAt)}"
            tv_updatedAt.text = "Updated: ${getDate(item.updatedAt)}"
            setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToDetailFragment(item)
                holder.itemView.findNavController().navigate(action)
            }
        }
        Log.d(TAG, "onBindViewHolder: $item")

    }

    private fun getDate(date: Long): String? {
       return try {
           val sdf = SimpleDateFormat("MM/dd/yyyy")
           val netDate = Date(date)
           Log.d(TAG, "getDate: $netDate")
           sdf.format(netDate)
       } catch (ex: Exception) {
           Log.d(TAG, "getDate: ${ex.message}")
           ex.message
       }
    }
}