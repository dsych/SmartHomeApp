package com.example.dmytro.smarthome;

/**
 * Created by Dmytro on 10/7/2018.
 */

public class Feature {
    Room parentRoom;
    String name;

    public Feature(Room parentRoom, String name) {
        this.parentRoom = parentRoom;
        this.name = name;
    }

    public Room getParentRoom() {
        return parentRoom;
    }

    public String getName() {
        return name;
    }
}
