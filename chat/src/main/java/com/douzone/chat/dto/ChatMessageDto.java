package com.douzone.chat.dto;

public class ChatMessageDto {
	private int chatRoomNo;
    private String msg;
    private String send_user_no;
	public int getChatRoomNo() {
		return chatRoomNo;
	}
	public void setChatRoomNo(int chatRoomNo) {
		this.chatRoomNo = chatRoomNo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSend_user_no() {
		return send_user_no;
	}
	public void setSend_user_no(String send_user_no) {
		this.send_user_no = send_user_no;
	} 
    
    
}
