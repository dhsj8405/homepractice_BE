package com.douzone.chat.dto;

public class ChatRoomDto {
	private int roomId;
	private String roomName;
	private int userNo;
	private String inputMessage;	// 채팅 방 생성 후 전송할 메시지
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getInputMessage() {
		return inputMessage;
	}
	public void setInputMessage(String inputMessage) {
		this.inputMessage = inputMessage;
	}

	

}
