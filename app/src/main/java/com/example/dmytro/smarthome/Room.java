package com.example.dmytro.smarthome;

/**
 * Created by Dmytro on 10/7/2018.
 */

public class Room {
    Feature parentFeature;
    String name;

    public Room(Feature parentFeature, String name) {
        this.parentFeature = parentFeature;
        this.name = name;
    }

    public Feature getParentFeature() {
        return parentFeature;
    }

    public String getName() {
        return name;
    }
}
