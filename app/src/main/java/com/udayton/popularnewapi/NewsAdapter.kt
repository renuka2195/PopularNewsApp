package com.test.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjava2newsapi.model.Article
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
        }
    }

}