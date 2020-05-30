package com.example.recyclerviewdatabinding.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdatabinding.R
import com.example.recyclerviewdatabinding.databinding.MainFragmentBinding

// Fragmentのコンストラクタにレイアウトを渡すとonCreateViewを書かなくても自動でinfateしてくれる
class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        private val TAG = "MainFragment"
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )

        // ?
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.also {
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
        binding.recyclerView.addItemDecoration(itemDecoration)
    }

    // RecyclerViewで表示するデータの作成
    private fun initData(): List<MainViewModel> {
        val arr = Array(30) { i -> "This is element # $i" }
        return arr.map {
            MainViewModel(it)
        }
    }
}
