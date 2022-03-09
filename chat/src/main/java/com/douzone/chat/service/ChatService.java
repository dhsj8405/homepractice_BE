package com.douzone.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.chat.dto.ChatRoomDto;
import com.douzone.chat.repository.ChatRepository;
import com.douzone.chat.vo.UserVo;

@Service
public class ChatService {
	
	@Autowired
	private ChatRepository chatRepository;
	
	public void addChatRoom(List<UserVo> list) {
		ChatRoomDto chatRoomDto = new ChatRoomDto();
		Long roomNo = chatRepository.addRoom(chatRoomDto);
		
		for(UserVo userVo: list){
//			chatRepository.add
		}
	}

}
