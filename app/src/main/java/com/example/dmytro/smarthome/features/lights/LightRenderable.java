package com.example.dmytro.smarthome.features.lights;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.dmytro.smarthome.R;
import com.example.dmytro.smarthome.features.IRenderable;

public class LightRenderable implements IRenderable {
    String name;
    boolean state;
    Context context;
    View view;

    public LightRenderable(String name, boolean state, Context context) {
        this.name = name;
        this.state = state;
        this.context = context;
    }

    public View render() {
        LayoutInflater inflater = (LayoutInflater)   this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.lights_feature, null);

        TextView name = view.findViewById(R.id.lights_caption);
        name.setText(this.name);

        this.setState(this.state);

        return view;
    }

    public void setState(boolean state) {
        this.state = state;

        ToggleButton toggle = view.findViewById(R.id.lights_value);
        toggle.setChecked(this.state);

    }
}
