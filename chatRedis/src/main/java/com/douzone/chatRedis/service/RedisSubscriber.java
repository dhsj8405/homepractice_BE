package com.douzone.chatRedis.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.douzone.chatRedis.dto.ChatMessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RedisSubscriber implements MessageListener {

	
    private final ObjectMapper objectMapper;
    
    // redis에 보내는 템플릿
    private final RedisTemplate redisTemplate;
   
    // client에 보내는 템플릿
    private final SimpMessagingTemplate messagingTemplate;

	public RedisSubscriber(ObjectMapper objectMapper, RedisTemplate redisTemplate,
			SimpMessagingTemplate messagingTemplate) {
		super(); 
		this.objectMapper = objectMapper;
		this.redisTemplate = redisTemplate;
		this.messagingTemplate = messagingTemplate;
	}
    
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try{
        	System.out.println("++++++++++Redis sub+++++++++++");
            String pubMsg = (String) redisTemplate.getStringSerializer().deserialize(message.getBody());
            ChatMessageDto msgDto = objectMapper.readValue(pubMsg,ChatMessageDto.class);
 
            
            messagingTemplate.convertAndSend("/topic/chat/room/"+msgDto.getChatRoomNo(), msgDto);
            
            
//            switch(ChatMessageDto.getMsgType()){
//                case "chat":
//                    messagingTemplate.convertAndSend("/sub/chat/room/"+chatDTO.getRoomId(),chatDTO);
//                    break;
//                case "createRoom":
//                    messagingTemplate.convertAndSend("/sub/room/create",chatDTO);
//                    break;
//                case "messageAll":
//                    messagingTemplate.convertAndSend("/sub/chat/all",chatDTO);
//                    break;
//            }


        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
    }
}