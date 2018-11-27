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
    int layout;
    int insertion_point;

    public Feature(String name, int layout, int insertion_point) {
        this.name = name;
        rooms = new ArrayList<>();
        this.layout = layout;
        this.insertion_point = insertion_point;
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


    public List<Room> getRooms() {
        return rooms;
    }

    public int getLayout() {
        return layout;
    }

    public int getInsertion_point() {
        return insertion_point;
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
