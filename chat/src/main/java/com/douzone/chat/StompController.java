package com.douzone.chat;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.douzone.chat.dto.ChatMessageDto;
import com.douzone.chat.dto.ChatRoomDto;

@Controller
public class StompController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@MessageMapping("/chat/enter")
	public void enter(ChatRoomDto roomInfo) {
		System.out.println("zzzz");
		System.out.println(roomInfo.getRoomId());
		System.out.println(roomInfo.getRoomName());
		System.out.println(roomInfo.getUserNo());
		System.out.println(roomInfo.getInputMessage());
		roomInfo.setInputMessage(roomInfo.getUserNo() +"님이 채팅방에 참여하였습니다.");
		
		simpMessagingTemplate.convertAndSend("/topic/chat/room/a",roomInfo);
	}
	
	 @MessageMapping( "/chat/message")
	    public void message(ChatMessageDto message){

			System.out.println(message);
	    	
			simpMessagingTemplate.convertAndSend("/topic/chat/room/a" + message.getChatRoomNo(), message);
	    }
	
}