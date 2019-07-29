package com.regi.entersekt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.regi.cityslickersdk.model.Shop
import com.regi.entersekt.R
import kotlinx.android.synthetic.main.tile_item.view.*

class ShopAdapter : RecyclerView.Adapter<ShopAdapter.ViewHolder>() {

    private var items: List<Shop> = emptyList()

    fun loadItems(newItems: List<Shop>?) {
        if (newItems != null) {
            items = newItems
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tile_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.textView.text = items[position].name
    }
}