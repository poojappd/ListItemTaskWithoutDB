package com.example.listitemtask

import android.content.Context
import android.content.res.TypedArray
import android.media.Image
import android.widget.ImageView

data class Task(val taskLabel:String, val taskTime:String, val taskImageId: Int){
}
class TasksUtil private constructor(context: Context) {

    val tasks:MutableList<Task>

    init {
        val taskLabels = context.resources.getStringArray(R.array.taskLabels)
        val taskTimes = context.resources.getStringArray(R.array.taskTimes)
        val taskImages = context.resources.obtainTypedArray(R.array.images)
        tasks = mutableListOf()
        for(i in taskTimes.indices){
                val task = Task(taskLabels[i], taskTimes[i], taskImages.getResourceId(i, -1))
            tasks.add(task)
        }

    }

    companion object{
        private var INSTANCE : TasksUtil? = null

        fun getInstance(context: Context): TasksUtil {
            return INSTANCE ?: run{
                INSTANCE = TasksUtil(context)
                INSTANCE!!
            }
        }
    }

}
