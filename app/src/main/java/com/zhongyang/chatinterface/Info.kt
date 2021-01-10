package com.zhongyang.chatinterface

/**
 * @项目名称 ChatInterface
 * @类名 Info
 * @包名 com.zhongyang.chatinterface
 * @创建时间 2021/1/9 13:14
 * @作者 钟阳
 * @描述 消息实体类
 */
class Info(val content: String, val type: Int) {

    companion object {
        const val TYPE_RECEIVED = 0//接收类型消息
        const val TYPE_SEND = 1//发送类型消息
    }
}