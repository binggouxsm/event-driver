package com.eden.event.impl;

import com.eden.event.Event;
import com.eden.event.EventEngine;
import com.eden.event.EventHandler;
import com.eden.event.EventType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractEventEngine implements EventEngine {

    protected Map<String, List<EventHandler>> handlerMapper = new HashMap<>();

    public void register(String eventType, EventHandler handler){
        List<EventHandler> handlers = handlerMapper.get(eventType);
        if(handlers == null){
            handlers = new LinkedList<EventHandler>();
            handlerMapper.put(eventType, handlers);
        }
        handlers.add(handler);
    }

    public void unregister(String eventType, EventHandler handler){
        List<EventHandler> handlers = handlerMapper.get(eventType);
        if(handlers != null){
            handlers.remove(handler);
        }
    }

    public void process(Event event){
        List<EventHandler> handlers = handlerMapper.get(event.getType());
        if(handlers != null)
            handlers.stream().forEach(handler-> handler.handle(event));

        handlers = handlerMapper.get(EventType.ALL.toString());
        if(handlers != null)
            handlers.stream().forEach(handler-> handler.handle(event));
    }

    public abstract void put(Event event);
}
