package com.example.lesson3kotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson3kotlin.databinding.ListItem2Binding
import com.example.lesson3kotlin.extensions.loading

class MyAdapter2() : RecyclerView.Adapter<MyAdapter2.ViewHolder>() {

    private var list = arrayListOf<String>()

    fun setList(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItem2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private var viewBinding: ListItem2Binding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun onBind(image: String) {
            viewBinding.firstIV.loading(image)
        }

    }

}