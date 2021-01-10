package com.zhongyang.chatinterface

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @项目名称 ChatInterface
 * @类名 MsgViewHolder
 * @包名 com.zhongyang.chatinterface
 * @创建时间 2021/1/10 10:36
 * @作者 钟阳
 * @描述
 */
sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    class LeftViewHolder(view: View) : MsgViewHolder(view) {
        //找控件
        val leftMsg: TextView = view.findViewById(R.id.tv_leftMsg)
    }

    class RightViewHolder(view: View) : MsgViewHolder(view) {
        //找控件
        val rightMsg: TextView = view.findViewById(R.id.tv_rightMsg)
    }
}
