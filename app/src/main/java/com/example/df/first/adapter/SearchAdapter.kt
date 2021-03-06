package com.example.df.first.adapter

import android.content.Context
import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.df.first.R
import com.example.df.first.bean.Datas

class SearchAdapter(val context: Context, datas: MutableList<Datas>) :
        BaseQuickAdapter<Datas, BaseViewHolder>(R.layout.home_list_item, datas) {

    override fun convert(helper: BaseViewHolder, item: Datas?) {
        item ?: return
        helper.setText(R.id.homeItemTitle, Html.fromHtml(item.title))
                .setText(R.id.homeItemAuthor, item.author)
                .setText(R.id.homeItemType, item.chapterName)
                .setText(R.id.homeItemDate,
                        if (item.originId != 0) context.getString(
                                R.string.bookmark_time,
                                item.niceData) else item.niceData
                )
                .addOnClickListener(R.id.homeItemType)
                .setTextColor(R.id.homeItemType, context.resources.getColor(R.color.colorPrimary))
                .linkify(R.id.homeItemType)
                .setImageResource(
                        R.id.homeItemLike,
                        if (item.originId != 0 || item.collect) R.drawable.ic_action_like else R.drawable.ic_action_no_like
                )
                .addOnClickListener(R.id.homeItemLike)
    }

}