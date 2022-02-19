package com.blogspot.svdevs.flows.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.blogspot.svdevs.flows.db.TaskDao

class TasksViewModel @ViewModelInject constructor(
    private val dao:TaskDao
): ViewModel() {



}