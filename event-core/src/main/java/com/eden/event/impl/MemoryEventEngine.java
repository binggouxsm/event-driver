package com.eden.event.impl;

import com.eden.event.Event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MemoryEventEngine extends AbstractEventEngine implements Runnable{

    private BlockingQueue<Event> queue = new LinkedBlockingQueue<>();

    public void run() {
        while (true){
            Event event = null;
            try {
                event = queue.take();
                process(event);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public void put(Event event){
        try {
            queue.put(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
