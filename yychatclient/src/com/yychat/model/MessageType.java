package com.yychat.model;

public interface MessageType {
	String message_LoginFailure="0";//字符串常量
	String message_LoginSuccess="1";
	String message_Common="2";
	String message_RequestOnlineFriend="3";
	String message_OnlineFriend="4";
	String message_NewOnlineFriend="5";//该消息类型是用来表示新用户上线了
    //新用户注册步骤6：添加Message对象的新类型
	String message_RegisterSuccess="6";
    String message_RegisterFailure="7";

}
