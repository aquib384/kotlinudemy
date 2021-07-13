package com.firstapp.kotlinudemy

import android.content.Context
import android.net.ConnectivityManager

class NetworkCalls {

    companion object{


        fun getConnectivityStatusString(context: Context): String? {
            var status: String? = null
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            if (activeNetwork != null) {
                if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                    status = "Wooh! You are back"
                    return status
                } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                    status = "Wooh! You are back"
                    return status
                }
            } else {
                status = "You are away from us!"
                return status
            }
            return status
        }

    }

}