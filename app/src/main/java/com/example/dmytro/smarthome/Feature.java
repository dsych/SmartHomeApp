package com.example.dmytro.smarthome;

import android.view.View;

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

    public View[] render() {
        View[] views = new View[this.rooms.size()];

        for(int i = 0; i < this.rooms.size(); i++) {
            views[i] = this.rooms.get(i).render();
        }
        return views;
    }


    public boolean addRoom(Room f) {
        return rooms.add(f);
    }

    public Room removeFeature(int index) {
        return rooms.remove(index);
    }

    public String getName() {
        return name;
    }
}
