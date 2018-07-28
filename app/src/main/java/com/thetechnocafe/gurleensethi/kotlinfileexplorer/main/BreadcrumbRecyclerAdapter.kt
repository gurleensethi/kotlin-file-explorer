package com.thetechnocafe.gurleensethi.kotlinfileexplorer.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thetechnocafe.gurleensethi.kotlinfileexplorer.R
import com.thetechnocafe.gurleensethi.kotlinfileexplorer.models.FileModel
import kotlinx.android.synthetic.main.item_recycler_breadcrumb.view.*

class BreadcrumbRecyclerAdapter : RecyclerView.Adapter<BreadcrumbRecyclerAdapter.ViewHolder>() {

    var onItemClickListener: ((FileModel) -> Unit)? = null

    var files = listOf<FileModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_breadcrumb, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = files.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindView(position)

    fun updateData(files: List<FileModel>) {
        this.files = files
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onItemClickListener?.invoke(files[adapterPosition])
        }

        fun bindView(position: Int) {
            val file = files[position]
            itemView.nameTextView.text = file.name
        }
    }
}