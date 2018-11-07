package com.example.dmytro.smarthome;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro on 10/7/2018.
 */

public class Feature {
    List<Room> rooms;
    String name;

    public Feature(String name) {
        this.name = name;
        rooms = new ArrayList<>();
    }

    public Feature(List<Room> rooms, String name) {
        this.rooms = rooms;
        this.name = name;
    }

    public boolean addFeature(Room f) {
        return rooms.add(f);
    }

    public Room removeFeature(int index) {
        return rooms.remove(index);
    }

    public String getName() {
        return name;
    }
}
