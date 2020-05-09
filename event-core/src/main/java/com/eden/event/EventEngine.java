package com.eden.event;



public interface EventEngine {
    /**
     * 注册事件处理器
     * @param eventType
     * @param handler
     */
    public void register(String eventType, EventHandler handler);
    /**
     * 注销事件处理器
     * @param eventType
     * @param handler
     */
    public void unregister(String eventType, EventHandler handler);

    /**
     * 消费事件
     * @param event
     */
    public void process(Event event);

    /**
     * 生产事件
     * @param event
     */
    public void put(Event event);

}
