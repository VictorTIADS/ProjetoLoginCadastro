package com.example.projetoandroidbsico.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoandroidbsico.Books
import com.example.projetoandroidbsico.ListItem
import com.example.projetoandroidbsico.R
import kotlinx.android.synthetic.main.listview.view.*

class Adapter (private  val context: Context, var list: ArrayList<Books>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val cardList = LayoutInflater.from(context).inflate(R.layout.listview, parent, false)
        return ViewHolder(cardList)
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var itemList = list[position]
        var title = holder.itemView.textView_Title
        var subtitle = holder.itemView.textView_Subtitle
        var btnDelete = holder.itemView.ImageButton_Delete


        title.text = itemList.title
        subtitle.text = itemList.subtitle

        btnDelete.setOnClickListener {
            list.remove(itemList)
            this.notifyItemRemoved(holder.adapterPosition)
        }


    }

    fun addItem(book:ArrayList<Books>){
        list = book
        this.notifyItemRangeInserted(itemCount,itemCount)
    }


}


class ViewHolder (val itemView: View) : RecyclerView.ViewHolder(itemView)