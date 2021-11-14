package com.example.lesson3kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson3kotlin.databinding.ListItemBinding

class MyAdapter(private var onClick: OnItemClick) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var list = arrayListOf<Int>()

    fun setList(list: ArrayList<Int>) {
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

        fun onBind(image: Int) {
            viewBinding.firstIV.setImageResource(image)

            viewBinding.firstIV.setOnClickListener {
                    viewBinding.backgroundIv.visibility = View.VISIBLE
                    onClick.onClick(image)
            }
            viewBinding.backgroundIv.setOnClickListener{
                viewBinding.backgroundIv.visibility = View.GONE
                onClick.deleteClick(image)

            }
        }
    }
    interface OnItemClick {

        fun onClick(image: Int)

        fun deleteClick(image: Int)
    }
}