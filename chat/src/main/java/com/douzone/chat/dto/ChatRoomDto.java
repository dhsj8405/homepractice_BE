package com.douzone.chat.dto;

public class ChatRoomDto {
	private Long no;
	private String name;
//	private int userNo;
//	private String inputMessage;	// 채팅 방 생성 후 전송할 메시지
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		

}
