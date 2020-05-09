package com.lutfi.cleanarchitecture.base.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

//created by Lutfi Rizky Ramadhan on 08/05/20

abstract class BaseViewHolder<Data>(protected var mContext: Context?,
                                    itemView: View,
                                    private val mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?,
                                    private val mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

    var isHasHeader = false

    init {
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    abstract fun bind(data: Data)

    override fun onClick(v: View) {
        mItemClickListener?.onItemClick(v, if (isHasHeader) adapterPosition - 1 else adapterPosition)
    }

    override fun onLongClick(v: View): Boolean {
        if (mLongItemClickListener != null) {
            mLongItemClickListener.onLongItemClick(v, if (isHasHeader) adapterPosition - 1 else adapterPosition)
            return true
        }
        return false
    }
}