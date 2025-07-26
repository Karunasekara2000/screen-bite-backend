package com.screenbite.backend.model.enumeration;


public enum Day{

    MONDAY("MONDAY"),
    TUESDAY("TUESDAY"),
    WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"),
    FRIDAY("FRIDAY"),
    SATURDAY("SATURDAY"),
    SUNDAY("SUNDAY");

    private String value;

    Day(String value){
        this.value = value;
    }

    public String getValue(){
      return value;
    };
}

