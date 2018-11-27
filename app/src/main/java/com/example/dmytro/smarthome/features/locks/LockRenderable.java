package com.example.dmytro.smarthome.features.locks;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.dmytro.smarthome.R;
import com.example.dmytro.smarthome.features.IRenderable;
import com.example.dmytro.smarthome.features.IRenderableSubject;
import com.example.dmytro.smarthome.features.ISubject;

public class LockRenderable implements IRenderableSubject {
    String name;
    boolean state;
    Context context;
    View view;

    public LockRenderable(String name, boolean state, Context context) {
        this.name = name;
        this.state = state;
        this.context = context;
    }

    public View render() {
        LayoutInflater inflater = (LayoutInflater)   this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.locks_feature, null);

        TextView name = view.findViewById(R.id.locks_caption);
        name.setText(this.name);

        ImageButton toggle = view.findViewById(R.id.locks_value);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setState(!state);
            }
        });

        this.setState(this.state);

        return view;
    }

    public void setState(boolean state) {
        this.state = state;

        ImageButton toggle = view.findViewById(R.id.locks_value);

        toggle.setImageResource(this.state ? R.drawable.ic_locked_state : R.drawable.ic_unlocked_state);

    }

    public void receiveState(Object state) {
        this.setState((Boolean) state);
    }
}
