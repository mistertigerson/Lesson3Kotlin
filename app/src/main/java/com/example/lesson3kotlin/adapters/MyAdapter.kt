package com.example.lesson3kotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson3kotlin.databinding.ListItemBinding
import com.example.lesson3kotlin.extensions.loading
import com.example.lesson3kotlin.extensions.visible

class MyAdapter(private var onClick: OnItemClick) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var list = arrayListOf<String>()

    fun setList(list: ArrayList<String>) {
        this.list.addAll(list)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private var viewBinding: ListItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun onBind(image: String) {
            viewBinding.firstIV.loading(image)

            viewBinding.firstIV.setOnClickListener {
                viewBinding.backgroundIv.visible = true
                onClick.onClick(image)
            }
            viewBinding.backgroundIv.setOnClickListener {
                viewBinding.backgroundIv.visible = false
                onClick.deleteClick(image)

            }
        }
    }

    interface OnItemClick {

        fun onClick(image: String)

        fun deleteClick(image: String)
    }
}