package com.example.listitemtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskRecyclerViewAdapter(val context: Context, val tasks:List<Task>) :RecyclerView.Adapter<TaskRecyclerViewAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val taskLabel: TextView = view.findViewById<TextView>(R.id.task_label)
        val imageView: ImageView = view.findViewById<ImageView>(R.id.task_icon)

        val taskTime: TextView = view.findViewById<TextView>(R.id.task_time)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent ,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks.get(position)
        holder.imageView.setImageResource(task.taskImageId)
        holder.taskLabel.text = task.taskLabel
        holder.taskTime.text = task.taskTime
    }

    override fun getItemCount() = tasks.size

}