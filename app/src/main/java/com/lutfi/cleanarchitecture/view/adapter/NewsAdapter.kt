package com.lutfi.cleanarchitecture.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.lutfi.cleanarchitecture.base.adapter.BaseRecyclerAdapter
import com.lutfi.cleanarchitecture.base.adapter.BaseViewHolder
import com.lutfi.cleanarchitecture.data.model.News

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

class NewsAdapter(context: Context, data: MutableList<News>) :
    BaseRecyclerAdapter<News, BaseViewHolder<News>>(context, data) {
    override fun getItemResourceLayout(viewType: Int): Int {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<News> {
        return NewsViewHolder(
            mContext,
            getView(parent, viewType),
            mItemClickListener!!,
            mLongItemClickListener!!
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<News>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(mDatas[position])
    }

    inner class NewsViewHolder(
        mContext: Context,
        itemView: View,
        mItemClickListener: OnItemClickListener,
        mLongItemClickListener: OnLongItemClickListener
    ) : BaseViewHolder<News>(mContext, itemView, mItemClickListener, mLongItemClickListener) {

        override fun bind(data: News) {

        }

    }
}