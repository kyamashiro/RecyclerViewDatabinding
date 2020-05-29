package com.example.recyclerviewdatabinding.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdatabinding.R

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        private val TAG = "MainFragment"
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.rootView.findViewById(R.id.recycler_view)
        recyclerView.also {
            // RecyclerViewにレイアウトをセットする
            it.layoutManager = LinearLayoutManager(activity)
            // RecyclerViewにアダプタをセットする
            it.adapter = RecyclerViewAdapter(initData(), layoutInflater)
        }

        // RecyclerViewのリストに区切り線をつける
        val itemDecoration = DividerItemDecoration(
            this.context,
            DividerItemDecoration.VERTICAL
        )
        recyclerView.addItemDecoration(itemDecoration)
    }

    // RecyclerViewで表示するデータの作成
    private fun initData(): List<MainViewModel> {
        val arr = Array(30) { i -> "This is element # $i" }
        return arr.map {
            MainViewModel(it)
        }
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        // TODO: Use the ViewModel
//    }
}
