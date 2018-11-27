package com.example.dmytro.smarthome;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.dmytro.smarthome.features.lights.LightRenderable;
import com.example.dmytro.smarthome.features.locks.LockRenderable;
import com.example.dmytro.smarthome.layout.HomeScreenFragment;


import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    final List<Feature> features = Arrays.asList(
            new Feature("Security", R.layout.fragment_security, R.id.securityContent),
            new Feature("Lights", R.layout.fragment_details, R.id.detailsContent),
            new Feature("Thermostat", R.layout.fragment_details, R.id.detailsContent),
            new Feature("Appliances", R.layout.fragment_details, R.id.detailsContent),
            new Feature("Inventories", R.layout.fragment_details, R.id.detailsContent),
            new Feature("Utilities", R.layout.fragment_details, R.id.detailsContent),
            new Feature("Schedules", R.layout.fragment_details, R.id.detailsContent),
            new Feature("Reminders", R.layout.fragment_details, R.id.detailsContent)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 1; i < features.size(); i++) {
            Feature currentFeature = features.get(i);
            Room room = new Room(currentFeature, "Kitchen", this, R.layout.room_view);
            room.addFeature(new LightRenderable("Stove Light", false, this));
            room.addFeature(new LightRenderable("Main Light", false, this));
            currentFeature.addRoom(room);

            room = new Room(currentFeature, "Living Room", this, R.layout.room_view);
            room.addFeature(new LightRenderable("Main Light", false, this));
            currentFeature.addRoom(room);
        }
        // initialize security tab
        Room room = new Room(features.get(0),"Study", this, R.layout.room_view_lock_unlock);
        room.addFeature(new LockRenderable(room.getName(), false, this));
        features.get(0).addRoom(room);
        room = new Room(features.get(0),"Back door", this, R.layout.room_view_lock_unlock);
        room.addFeature(new LockRenderable(room.getName(), false, this));
        features.get(0).addRoom(room);
        room = new Room(features.get(0),"Garage", this, R.layout.room_view_lock_unlock);
        room.addFeature(new LockRenderable(room.getName(), true, this));
        features.get(0).addRoom(room);
        room = new Room(features.get(0),"Front door", this, R.layout.room_view_lock_unlock);
        room.addFeature(new LockRenderable(room.getName(), true, this));
        features.get(0).addRoom(room);
        room = new Room(features.get(0),"Safe", this, R.layout.room_view_lock_unlock);
        room.addFeature(new LockRenderable(room.getName(), false, this));
        features.get(0).addRoom(room);

        Toolbar myToolbar = findViewById(R.id.toolbar);
//        setActionBar(myToolbar);


        HomeScreenFragment homeScreen = HomeScreenFragment.newInstance(features);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, homeScreen).commit();

    }
}