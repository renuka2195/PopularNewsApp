package com.test.myapplication

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjava2newsapi.model.Article
import com.squareup.picasso.Picasso
import com.udayton.popularnewapi.NewsDetail
import com.udayton.popularnewapi.R
import kotlinx.android.synthetic.main.news_item.view.*


//class DataAdapter(val items: ArrayList<Model.Employee>, val context: FragmentActivity?) : RecyclerView.Adapter<DataAdapter.ItemHolder>() {
class NewsAdapter(val items: ArrayList<Article>) : RecyclerView.Adapter<NewsAdapter.ItemHolder>() {

    override
    fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ItemHolder(view)
    }

    override
    fun onBindViewHolder(viewHolder: ItemHolder, position: Int) {
        val article = items.get(position)
        viewHolder.bind(article)
        Picasso.
            with(viewHolder.itemView.context).
            load(article.urlToImage).
            into(viewHolder.itemView.urlImage)

        viewHolder.itemView.url.setOnClickListener {
            viewHolder.itemView.context.startActivity(Intent(viewHolder.itemView.context, NewsDetail::class.java))
        }

        viewHolder.itemView.url.setOnClickListener(View.OnClickListener {

            val intent = Intent(viewHolder.itemView.context, NewsDetail::class.java)
            intent.putExtra("url", article.url)
            viewHolder.itemView.context.startActivity(intent)
        })

    }
    fun add(list: ArrayList<Article>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            itemView.title.text = article.title
            itemView.content.text = article.content;
            itemView.url.text = article.url;
            itemView.publication.text=article.publishedAt;
            itemView.author.text = article.author;
        }
    }

}
/* fun swipeNextNews(viewHolder: RecyclerView.ViewHolder, position: Int){
        val article = items.get(position+1)
        val intent = Intent(viewHolder.itemView.context, NewsDetail::class.java)
        intent.putExtra("url", article.url)
        viewHolder.itemView.context.startActivity(intent)
    }*/