package com.furkan.cs473mobiledeviceprogramming

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = ("Create table if not exists " + TABLE_NAME +
                "(" + KEY_ROWID + " integer PRIMARY KEY AUTOINCREMENT," +
                Q + " text," + A1 + " text," + A2 + " text," + A3 + " text," + CA + " text)")
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    companion object {
        val DB_NAME = "Questions"
        val DB_VERSION = 2

        val TABLE_NAME = "quiz"
        val Q = "question"
        val A1 = "answerA"
        val A2 = "answerB"
        val A3 = "answerC"
        val CA = "correctAnswer"
        val KEY_ROWID = "_id"
    }
}
