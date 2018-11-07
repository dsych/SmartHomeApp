package com.example.dmytro.smarthome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dmytro.smarthome.features.IRenderable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dmytro on 10/7/2018.
 */

public class Room implements IRenderable {
    Feature parentFeature;
    String name;
    Context context;
    View view;

    List<IRenderable> features;

    public Room(Feature parentFeature, String name, Context context) {
        this.parentFeature = parentFeature;
        this.name = name;
        this.features = new LinkedList<>();
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void addFeature(IRenderable feature) {
        this.features.add(feature);
    }

    public View render() {
        LayoutInflater inflater = (LayoutInflater)   this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.room_view, null);

        TextView header = view.findViewById(R.id.header_text);
        header.setText(this.name);

        for(int i = 0; i < this.features.size(); i++) {
            View featureView = this.features.get(i).render();
            LinearLayout vg = this.view.findViewById(R.id.roomContent);
            vg.addView(featureView);
        }

        return view;
    }

}
