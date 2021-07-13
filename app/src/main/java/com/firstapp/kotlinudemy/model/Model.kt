package com.firstapp.kotlinudemy.model



class Model(userId:Int?, title:String?, body:String?) {
    private var userId: Int = userId!!
    private var title: String = title!!
    private var body: String = body!!

    fun getUserId(): Int {
        return userId

    }
    fun getTitle(): String {
        return title

    }

    fun getBody(): String {
        return body

    }

}