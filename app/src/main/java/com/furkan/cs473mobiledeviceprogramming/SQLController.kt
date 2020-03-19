package com.furkan.cs473mobiledeviceprogramming

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase

class SQLController(c: Context) // Constructor to set the context
{
    lateinit var dbhelper: DBHelper
    lateinit var ourcontext: Context
    lateinit var database: SQLiteDatabase

    init {
        ourcontext = c
    }

    fun open(): SQLController {
        dbhelper = DBHelper(ourcontext)
        database = dbhelper.getWritableDatabase()
        return this
    }

    fun close() {
        dbhelper.close()
    }

    fun insertData(q: String, a1: String, a2: String, a3: String, ca: String) {
        val cv = ContentValues()
        cv.put(DBHelper.Q, q)
        cv.put(DBHelper.A1, a1)
        cv.put(DBHelper.A2, a2)
        cv.put(DBHelper.A3, a3)
        cv.put(DBHelper.CA, ca)
        database.insert(DBHelper.TABLE_NAME, null, cv)
    }

    fun readData(): Cursor {
        val allColumns = arrayOf<String>(
            DBHelper.KEY_ROWID,
            DBHelper.Q,
            DBHelper.A1,
            DBHelper.A2,
            DBHelper.A3,
            DBHelper.CA
        )
        val c = database.query(DBHelper.TABLE_NAME, allColumns, null, null, null, null, null)
        c?.moveToFirst()
        return c
    }
}