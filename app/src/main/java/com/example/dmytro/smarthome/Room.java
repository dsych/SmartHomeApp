package com.example.dmytro.smarthome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dmytro.smarthome.features.IRenderable;
import com.example.dmytro.smarthome.features.IRenderableSubject;

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
    int viewId;

    List<IRenderableSubject> features;

    public Room(Feature parentFeature, String name, Context context, int viewId) {
        this.parentFeature = parentFeature;
        this.name = name;
        this.features = new LinkedList<>();
        this.context = context;
        this.viewId = viewId;
    }

    public String getName() {
        return name;
    }

    public void addFeature(IRenderableSubject feature) {
        this.features.add(feature);
    }

    public View render() {
        LayoutInflater inflater = (LayoutInflater)   this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(this.viewId, null);

        TextView header = view.findViewById(R.id.header_text);
        if(header != null) {
            header.setText(this.name);
        }

        for(int i = 0; i < this.features.size(); i++) {
            View featureView = this.features.get(i).render();
            LinearLayout vg = this.view.findViewById(R.id.roomContent);
            vg.addView(featureView);
        }

        return view;
    }

    public List<IRenderableSubject> getFeatures() {
        return features;
    }

    public void notifyChildren(Object value) {
        for(int i = 0; i < this.features.size(); i++) {
            this.features.get(i).receiveState(value);
        }
    }
}
