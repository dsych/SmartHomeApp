package com.example.dmytro.smarthome;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro on 10/7/2018.
 */

public class Room {
    List<Feature> features;
    String name;

    public Room(String name) {
        this.name = name;
        features = new ArrayList<>();
    }

    public Room(List<Feature> features, String name) {
        this.features = features;
        this.name = name;
    }

    public boolean addFeature(Feature f) {
        return features.add(f);
    }

    public Feature removeFeature(int index) {
        return features.remove(index);
    }

    public String getName() {
        return name;
    }
}
