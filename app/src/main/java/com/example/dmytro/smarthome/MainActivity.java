package com.example.dmytro.smarthome;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.dmytro.smarthome.layout.HomeScreenFragment;


import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    final List<Feature> features = Arrays.asList(
            new Feature("Security"),
            new Feature("Lights"),
            new Feature("Thermostat"),
            new Feature("Appliances"),
            new Feature("Inventories"),
            new Feature("Utilities"),
            new Feature("Schedules"),
            new Feature("Reminders")
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 0; i < features.size(); i++) {
            Feature currentFeature = features.get(i);
            currentFeature.addFeature(new Room(currentFeature, "Lights"));
        }

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setActionBar(myToolbar);


        HomeScreenFragment homeScreen = HomeScreenFragment.newInstance(features);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, homeScreen).commit();

    }
}