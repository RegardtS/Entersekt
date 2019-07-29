package com.regi.entersekt.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.regi.cityslickersdk.model.Mall
import com.regi.entersekt.CityActivity
import com.regi.entersekt.MallActivity
import com.regi.entersekt.R
import kotlinx.android.synthetic.main.tile_item.view.*

class MallAdapter : RecyclerView.Adapter<MallAdapter.ViewHolder>() {

    private var items: List<Mall> = emptyList()

    fun loadItems(newItems: List<Mall>?) {
        if (newItems != null) {
            items = newItems
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.textView.text = items[position].name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MallActivity::class.java)
            intent.putExtra(CityActivity.SELECTED_CITY_INDEX, CityActivity.index)
            intent.putExtra(MallActivity.SELECTED_MALL_INDEX, position)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }
}