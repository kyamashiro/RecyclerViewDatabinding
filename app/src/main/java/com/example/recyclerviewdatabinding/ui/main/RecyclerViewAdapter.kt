package com.example.recyclerviewdatabinding.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdatabinding.R
import com.example.recyclerviewdatabinding.databinding.RecyclerViewItemBinding

class RecyclerViewAdapter(private val dataSet: List<MainViewModel>, private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val binding = DataBindingUtil.inflate<RecyclerViewItemBinding>(
            layoutInflater,
            R.layout.recycler_view_item,
            viewGroup,
            false
        )
        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // リストの行にデータをセットする
        viewHolder.bind(dataSet.get(position))

        // 個別のアイエムをクリックしたときの挙動はViewHolderに書くべきなのか？
        // ViewHolderの役割とは？
        viewHolder.binding.button.setOnClickListener {
            Toast.makeText(viewHolder.itemView.context, "Element $position button pushed.", Toast.LENGTH_SHORT).show()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    companion object {
        private val TAG = "RecyclerViewAdapter"
    }


    /**
     * カスタムviewHolder
     */
    class ViewHolder(val binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.textView.setOnClickListener {
                Toast.makeText(binding.root.context, "Element $adapterPosition clicked.", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(mainViewModel: MainViewModel) {
            binding.viewModel = mainViewModel
        }
    }
}
