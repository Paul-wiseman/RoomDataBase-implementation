package com.wiseman.paul.androidroomdatabase.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/*
this User class represents an entity inside the Room database
* an entity represents a table with in the database*/
@Parcelize
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int, // the id is a primary key and is automatically generated by the room library
    val firstName: String,
    val lastName: String,
    val age: Int
): Parcelable



@Entity(tableName = "my_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int, // the id is a primary key and is automatically generated by the room library
    val firstName: String,
    val lastName: String,
    val age: Int,
    @Embedded
    val address: Address
)

data class Address(
    val streetName: String,
    val streetNumber: Int
)