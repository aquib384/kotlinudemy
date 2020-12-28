package com.firstapp.kotlinudemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG="MainActivity"
private const val TEXT_CONTENTS="TextContents"


class MainActivity : AppCompatActivity() {

    var textView:TextView?=null


    private var numTimeCLicked=0
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate:called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_layout)

        val userInput:EditText=findViewById<EditText>(R.id.userInput)
        textView=findViewById<TextView>(R.id.textView)
        val button=findViewById<Button>(R.id.button)
        textView?.text=""
        userInput.setText("Name")
        textView?.movementMethod=ScrollingMovementMethod()
        
        button?.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                Log.d(TAG,"onClicked:called")
                textView?.append(userInput.text)
                textView?.append("\n")
                userInput.text.clear()

            }

        })



    }

    override fun onStart() {
        Log.d(TAG,"onStart:called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG,"onRestoreInstanceState:called")
        super.onRestoreInstanceState(savedInstanceState)
        val savedString=savedInstanceState?.getString(TEXT_CONTENTS,"")
        textView?.text=savedString

    }

    override fun onResume() {
        Log.d(TAG,"onResume:called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause:called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG,"onSaveInstanceState:called")
        super.onSaveInstanceState(outState)
      outState?.putString(TEXT_CONTENTS,textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG,"onStop:called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy:called")
        super.onDestroy()
    }
}