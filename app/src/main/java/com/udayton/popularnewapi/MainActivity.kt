package com.udayton.popularnewapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.myapplication.NewsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mAdapter = NewsAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val country = "us"

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = mAdapter

        NewsAPIClient.create().topHeadlines(
            country,
            NewsApi.KEY
        ).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                if (response.status == "ok") {
                    mAdapter.add(response.articles)
                }
            }, { error ->
                error.printStackTrace()
                Log.d("error", "errors")
            })

    }
}

/*
                for (i in itemsList.indices){
                    itemsList.add(itemsList[i])
                    Log.d("items",itemsList[i].toString())
                }*/