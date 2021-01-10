package com.zhongyang.chatinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mMsgList = ArrayList<Info>()
    private lateinit var mMsgAdapter: MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化消息数据
        initMsgData()
        //初始化适配器相关
        initAdapter()
        //初始化事件
        initEvent()
    }

    private fun initEvent() {
        //发送按钮点击事件
        iv_send.setOnClickListener {
            //发送消息逻辑
            sedMsgLogic()
        }
    }

    private fun sedMsgLogic() {
        //获取输入框内容
        val userInfo = et_systemBox.text.toString()
        //判空
        if (userInfo.isNotEmpty()) {
            //封装数据
            mMsgList.add(Info(userInfo, Info.TYPE_SEND))
            //更新适配器内容
            mMsgAdapter.notifyItemInserted(mMsgList.size - 1)
            //更新适配器显示位置
            rv_chatInfo.scrollToPosition(mMsgList.size - 1)
            //清空输入框
            et_systemBox.setText("")
        } else {
            Toast.makeText(this, "请输入要发送的内容", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initAdapter() {
        //设置布局管理器
        val linearLayoutManager = LinearLayoutManager(this)
        rv_chatInfo.layoutManager = linearLayoutManager
        //设置适配器
        mMsgAdapter = MsgAdapter(mMsgList)
        rv_chatInfo.adapter = mMsgAdapter
    }

    private fun initMsgData() {
        //封装消息数据
        mMsgList.add(Info("你好！张三", Info.TYPE_RECEIVED))
        mMsgList.add(Info("你好！李四", Info.TYPE_SEND))
        mMsgList.add(Info("今天想找你借点钱...", Info.TYPE_RECEIVED))
    }
}