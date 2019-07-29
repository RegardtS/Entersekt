package com.regi.entersekt.mainActivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.regi.entersekt.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val adapter = MainRecyclerAdapter()
        recyclerView.adapter = adapter

        viewModel.cityListLiveData.observe(this, Observer {
            animation_view.visibility = if (it.isNotEmpty()) View.GONE else View.VISIBLE
            textView.visibility = if (it.isNotEmpty()) View.GONE else View.VISIBLE
            adapter.loadItems(it)
        })

        viewModel.errorText.observe(this, Observer {
            textView.text = getString(R.string.error_text,it)
        })

        textView.setOnClickListener {
            textView.text = getString(R.string.retrying_text)
            viewModel.refresh()
        }
    }
}


