package com.regi.entersekt

import android.os.Bundle
import com.regi.cityslickersdk.CitySlicker
import com.regi.entersekt.adapter.ShopAdapter
import com.regi.entersekt.base.BaseActivity
import kotlinx.android.synthetic.main.activity_mall.*

class MallActivity : BaseActivity() {

    companion object{
        const val SELECTED_MALL_INDEX = "SELECTED_MALL_INDEX"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mall)

        val mallIndex = intent.getIntExtra(SELECTED_MALL_INDEX,0)
        val cityIndex = intent.getIntExtra(CityActivity.SELECTED_CITY_INDEX,0)

        title = CitySlicker.instance.getMallName(cityIndex,mallIndex)

        val shopAdapter = ShopAdapter()
        shopsRecyclerView.adapter = shopAdapter
        val shops = CitySlicker.instance.getShopsFromMall(cityIndex, mallIndex)
        shopAdapter.loadItems(shops)
    }
}
