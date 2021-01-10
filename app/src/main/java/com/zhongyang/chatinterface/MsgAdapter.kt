package com.zhongyang.chatinterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

/**
 * @项目名称 ChatInterface
 * @类名 MsgAdapter
 * @包名 com.zhongyang.chatinterface
 * @创建时间 2021/1/9 13:25
 * @作者 钟阳
 * @描述 信息适配器
 */
class MsgAdapter(val msgList: ArrayList<Info>) : RecyclerView.Adapter<MsgViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val info = msgList[position]
        return info.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == Info.TYPE_RECEIVED) {
            val leftView = LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_left_item, parent, false)
            //返回条目布局
            MsgViewHolder.LeftViewHolder(leftView)
        } else {
            val rightView = LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_right_item, parent, false)
            //返回条目布局
            MsgViewHolder.RightViewHolder(rightView)
        }


    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        //绑定数据
        val info = msgList[position]
        when (holder) {
            is MsgViewHolder.LeftViewHolder -> holder.leftMsg.text = info.content
            is MsgViewHolder.RightViewHolder -> holder.rightMsg.text = info.content
        }
    }

    override fun getItemCount(): Int {
        //返回条目个数
        return msgList.size
    }
}