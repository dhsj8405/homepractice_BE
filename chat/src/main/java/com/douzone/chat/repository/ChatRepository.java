package com.douzone.chat.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.chat.dto.ChatMessageDto;
import com.douzone.chat.dto.ChatRoomDto;
import com.douzone.chat.vo.UserVo;

@Repository
public class ChatRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public List<UserVo> findAll() {
		return sqlSession.selectList("user.findAllId");	
	}

	public Long addRoom(ChatRoomDto chatRoomDto) {
		sqlSession.insert("chat.createRoom",chatRoomDto);
//		System.out.println();
		return chatRoomDto.getNo();
	}

	public void addJoinChatRoom(Map<String, Object> map) {
		sqlSession.insert("chat.createChatInfo",map);
	}

	public List<ChatMessageDto> findAllMessage(int i) {
		return sqlSession.selectList("chat.findAllMessage");
		
	}
	
}
