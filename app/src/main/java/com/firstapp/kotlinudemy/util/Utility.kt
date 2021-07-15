package com.firstapp.kotlinudemy.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class Utility  {

    companion object{

        fun showFragment(manager: FragmentManager, fragment: Fragment?, frameId: Int) {
            val transaction = manager.beginTransaction()
            transaction.replace(frameId, fragment!!)
            transaction.commit()
        }
//creating inline and extension function
        inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
            val fragmentTransaction = beginTransaction()
            fragmentTransaction.func()
            fragmentTransaction.commit()
        }

    }
}

