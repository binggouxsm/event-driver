package com.eden.event;

public enum EventType {
    TICK("eTick."),TRADE("eTrade."),
    ORDER("eOrder."),POSITION("ePosition."),
    ACCOUNT("eAccount."),ALL("eAll");

    private String meaning;

    EventType(String meaning){
        this.meaning = meaning;
    }

    public String getMeaning(){
        return meaning;
    }

    public String toString(){
        return meaning;
    }
}
