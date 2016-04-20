package com.ucl.epl.lfsab1509.groupe20.meetinghaters;

/**
 * Created by ludovic on 23/03/16.
 */
public class MeetingItem {

    private String name;
    private String description;
    private String start;     // can be modified in order to use a custom object for the date
    private String end;       // can be modified in order to use a custom object for the date
    private String location;  // can be modified in order to use a custom object for the laction


    public MeetingItem(String name, String description, String start, String end, String location){
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }



}