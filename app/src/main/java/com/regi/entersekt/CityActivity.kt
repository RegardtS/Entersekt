package com.regi.entersekt

import android.os.Bundle
import com.regi.cityslickersdk.CitySlicker
import com.regi.entersekt.adapter.MallAdapter
import com.regi.entersekt.adapter.ShopAdapter
import com.regi.entersekt.base.BaseActivity
import kotlinx.android.synthetic.main.activity_city.*

class CityActivity : BaseActivity() {

    companion object{
        const val SELECTED_CITY_INDEX = "SELECTED_CITY_INDEX"
        var index: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        index = intent.getIntExtra(SELECTED_CITY_INDEX,0)
        val cityName = CitySlicker.instance.getCity(index).name
        title = cityName
        textView.text = getString(R.string.all_shops_from_city,cityName)

        setupMallRecyclerView()
        setupShopRecyclerView()
    }

    private fun setupMallRecyclerView(){
        val mallAdapter = MallAdapter()
        mallRecyclerView.adapter = mallAdapter
        mallAdapter.loadItems(CitySlicker.instance.getMallsFromCity(index))
    }

    private fun setupShopRecyclerView(){
        val shopAdapter = ShopAdapter()
        shopRecyclerView.adapter = shopAdapter
        val shops = CitySlicker.instance.getShopsFromCity(index)
        shopAdapter.loadItems(shops)
    }
}
