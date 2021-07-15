package com.firstapp.kotlinudemy.pref

import android.content.Context
import android.content.SharedPreferences

object SessionManager {

    private lateinit var prefs: SharedPreferences
    private const val PREFS_NAME = "params"



    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }


    fun putData(key: String, value: String) {

        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putString(key, value)
            commit()
        }
    }



    fun getData(key:String): String? {
       return prefs.getString(key,null)
    }


}