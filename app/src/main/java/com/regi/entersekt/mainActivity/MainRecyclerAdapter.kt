package com.regi.entersekt.mainActivity

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.regi.cityslickersdk.model.City
import com.regi.entersekt.CityActivity
import com.regi.entersekt.R
import kotlinx.android.synthetic.main.list_item.view.*

class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>(){

    private var items: List<City> = emptyList()

    fun loadItems(newItems: List<City>){
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.textView.text = items[position].name
        holder.itemView.cardView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CityActivity::class.java)
            intent.putExtra(CityActivity.SELECTED_CITY_INDEX, position)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }
}