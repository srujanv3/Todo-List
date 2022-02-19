package com.blogspot.svdevs.flows.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Entity(tableName = "table_name")
@Parcelize
data class Task(
    val title: String,
    val isChecked: Boolean = false,
    val isImportant: Boolean = false,
    val created: Long = System.currentTimeMillis(),

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
): Parcelable{

    val dateFormatted: String
    get() = DateFormat.getDateTimeInstance().format(created)

}
