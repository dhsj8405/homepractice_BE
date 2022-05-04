package com.douzone.chatRedis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.douzone.chatRedis.dto.ChatMessageDto;

@Service
public class RedisPublisher {
    private RedisTemplate<String,Object> redisTemplate;

    public void publish(ChannelTopic topic, ChatMessageDto message){
    	System.out.println("redisPub");
        redisTemplate.convertAndSend(topic.getTopic(),message);
    }
}
