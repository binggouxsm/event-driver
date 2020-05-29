package com.eden.event.impl;

import com.eden.event.Event;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.io.Serializable;

public class RedisEventEngine extends AbstractEventEngine implements  MessageListener {

    private RedisTemplate<String, Serializable> redisTemplate;

    private RedisMessageListenerContainer redisContainer;

    public RedisEventEngine(RedisTemplate<String, Serializable> redisTemplate, RedisMessageListenerContainer redisContainer){
        this.redisTemplate = redisTemplate;
        this.redisContainer = redisContainer;
        this.redisContainer.addMessageListener(this, new PatternTopic(CHANNEL_NAME));
    }

    public void setRedisTemplate(RedisTemplate<String, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setRedisContainer(RedisMessageListenerContainer redisContainer) {
        this.redisContainer = redisContainer;
    }

    private static final String CHANNEL_NAME="eden.event";



    @Override
    public void put(Event event) {
        redisTemplate.convertAndSend(CHANNEL_NAME,event);
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        Object obj = redisTemplate.getValueSerializer().deserialize(message.getBody());
        if(obj instanceof Event){
            Event event = (Event) obj;
            System.out.println(event);
            process(event);
        }

    }


}
