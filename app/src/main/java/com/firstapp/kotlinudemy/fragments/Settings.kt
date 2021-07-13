package com.firstapp.kotlinudemy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.firstapp.kotlinudemy.R

class Settings(contentLayoutId: Int) : Fragment(contentLayoutId) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.settings,null,true)
    }
}