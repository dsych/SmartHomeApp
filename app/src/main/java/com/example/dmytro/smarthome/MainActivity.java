package com.example.dmytro.smarthome;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.dmytro.smarthome.layout.HomeScreenFragment;


import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    final List<Room> rooms = Arrays.asList(
            new Room("Kitchen"),
            new Room("Living Room"),
            new Room("Master Bedroom"),
            new Room("Bedroom"),
            new Room("Basement"),
            new Room("Guest Room"),
            new Room("Backyard"),
            new Room("Garage")
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 0; i < rooms.size(); i++) {
            Room currentRoom = rooms.get(i);
            currentRoom.addFeature(new Feature(currentRoom, "Lights"));
        }

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setActionBar(myToolbar);


        HomeScreenFragment homeScreen = HomeScreenFragment.newInstance(rooms);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, homeScreen).commit();

    }
}