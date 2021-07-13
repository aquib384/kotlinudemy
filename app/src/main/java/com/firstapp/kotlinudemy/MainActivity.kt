package com.firstapp.kotlinudemy


import android.os.Bundle
import android.text.TextUtils.replace
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.kotlinudemy.api.Api
import com.firstapp.kotlinudemy.api.PostApi
import com.firstapp.kotlinudemy.fragments.AboutUs
import com.firstapp.kotlinudemy.fragments.Help
import com.firstapp.kotlinudemy.fragments.Settings
import com.firstapp.kotlinudemy.model.Model
import com.firstapp.kotlinudemy.util.Utility
import com.firstapp.kotlinudemy.util.Utility.Companion.inTransaction
import retrofit2.*


class MainActivity : AppCompatActivity() {

    private val userList = ArrayList<Model>()
    private lateinit var userAdapter: Adapter
    private lateinit var retrofit: Retrofit
    private val aboutUs= AboutUs(1)
    private val help= Help(2)
    private val settings= Settings(3)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Init your recyclerview
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        userAdapter = Adapter(userList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = userAdapter

        prepareMovieData()
       }

    private fun prepareMovieData() {

        retrofit= Api.getRetrofitClient()

        val postApi: PostApi = retrofit.create(PostApi::class.java)


        val call: Call<List<Model>>? = postApi.getUser()
        call?.enqueue(object : Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {



                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
                    for (i in response.body()!!.indices) {
                        val userId: Int = response.body()?.get(i)!!.getUserId()
                        val title: String = response.body()?.get(i)!!.getTitle()
                        val body: String = response.body()?.get(i)!!.getBody()
                        userList.add(Model(userId, title, body))
                    }
                    userAdapter.notifyDataSetChanged()


                }
            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                print(t.message)
            }


        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.about ->{
                //using extension function
                Toast.makeText(this,"About Us",Toast.LENGTH_SHORT).show()
                supportFragmentManager.inTransaction {
                    replace(R.id.frame, aboutUs)


            }

                }


            R.id.help ->{
                Toast.makeText(this,"Help Us",Toast.LENGTH_SHORT).show()
                //using normal method call
                Utility.showFragment(supportFragmentManager,help,R.id.frame)

            }


            R.id.setting -> {
                Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show()
                Utility.showFragment(supportFragmentManager,settings,R.id.frame)

            }

        }


            return super.onOptionsItemSelected(item);

        }



}














