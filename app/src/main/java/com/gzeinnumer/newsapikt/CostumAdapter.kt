package com.gzeinnumer.newsapikt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gzeinnumer.newsapikt.model.ArticlesItem
import kotlinx.android.synthetic.main.item.view.*

class CostumAdapter(val contex: Context, val list: List<ArticlesItem>, val listener: (ArticlesItem) -> Unit) :
    RecyclerView.Adapter<CostumAdapter.MyHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder =
        MyHolder(LayoutInflater.from(contex).inflate(R.layout.item, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindItem(list[position], listener)
    }

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(articlesItem: ArticlesItem, listener: (ArticlesItem) -> Unit) {
            itemView.item_author.text = articlesItem.title
            itemView.item_name.text = articlesItem.title

            itemView.setOnClickListener{
                listener(articlesItem)
            }
        }

    }

}