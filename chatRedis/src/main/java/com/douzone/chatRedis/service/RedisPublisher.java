package com.douzone.chatRedis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.douzone.chatRedis.dto.ChatMessageDto;

// 레디스 메시지를 RedisSubscriber로 전달해준다.
@Service
public class RedisPublisher {
	@Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public void publish(ChannelTopic topic, ChatMessageDto message){
    	System.out.println("+++++++++++++Redis Pub++++++++++++");
    	System.out.println(topic.getTopic());
    	System.out.println(message);
        redisTemplate.convertAndSend(topic.getTopic(),message);
        System.out.println("++++++++++++++++++++++++++++++++++");
    }
}
