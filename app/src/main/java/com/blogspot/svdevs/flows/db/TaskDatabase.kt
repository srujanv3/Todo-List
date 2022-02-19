package com.blogspot.svdevs.flows.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.blogspot.svdevs.flows.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao


    // For adding dummy data in the room database (pre-populating)
    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ): RoomDatabase.Callback() {
        // this onCreate method will be executed after the build() function of the room database
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            // db operations
            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insert(Task("Hit the Gym"))
                dao.insert(Task("Take the dog for a walk", isChecked = true))
                dao.insert(Task("Complete episodes 99 & 100 of anime"))
                dao.insert(Task("Date @7:30 pm", isImportant = true))
                dao.insert(Task("Get the groceries", isChecked = true, isImportant = true))
            }
        }
    }

}