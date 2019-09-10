package com.gzeinnumer.newsapikt

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gzeinnumer.newsapikt.model.ArticlesItem
import com.gzeinnumer.newsapikt.model.ResponseNewsApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var adapterData: CostumAdapter? = null
    var list: MutableList<ArticlesItem> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        RetroServer.getInstance().getNews("bitcoin","2019-08-09","publishedAt","e5430ac2a413408aaafdf60bfa27a874")
        RetroServer.getInstance().getNews()
            .enqueue(object : Callback<ResponseNewsApi> {
                override fun onFailure(call: Call<ResponseNewsApi>, t: Throwable) {
                    Toast.makeText(applicationContext,t.message,Toast.LENGTH_SHORT).show()
                }

                @SuppressLint("WrongConstant")
                override fun onResponse(
                    call: Call<ResponseNewsApi>,
                    response: Response<ResponseNewsApi>
                ) {
                    Toast.makeText(applicationContext,"koneksi sukses",Toast.LENGTH_SHORT).show()

                    response.body()?.articles?.size?.let {
                        Toast.makeText(applicationContext,
                            it.toString(), Toast.LENGTH_SHORT).show()
                    }
                    response.body()?.articles?.let {
                        list.clear()
                        list.addAll(it)
                    }
                    adapterData = CostumAdapter(applicationContext, list) {
                        func(it)
                    }

                    rv!!.adapter=adapterData
                    rv!!.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL, false)
                }

            })
    }

    private fun func(it: ArticlesItem) {
        Toast.makeText(applicationContext,it.title,Toast.LENGTH_SHORT).show()
    }

}
