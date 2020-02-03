package com.udayton.popularnewapi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.news_item.*


class NewsDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val i = intent
        val url: String = intent.getStringExtra("url")
        webview.loadUrl(url)

        //val i = intent
      //  val url: String = intent.getStringExtra("url")
        //Toast.makeText(this,"URL "+url, Toast.LENGTH_LONG).show()



       /* var website: String = url
        if (!website.startsWith("http://") && !website.startsWith("https://")) website =
            "http://$website"
        try {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website))
            startActivity(browserIntent)
        } catch (e: Exception) {
        }*/
    }
}
