package com.example.dmytro.smarthome.layout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.dmytro.smarthome.Feature;
import com.example.dmytro.smarthome.R;
import com.example.dmytro.smarthome.Room;
import com.example.dmytro.smarthome.features.IRenderableSubject;

import java.util.List;


public class SecurityFragment extends Fragment {
    Feature feature;


    public SecurityFragment() {
        // Required empty public constructor
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param feature Parameter 1.
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecurityFragment newInstance(Feature feature) {
        SecurityFragment fragment = new SecurityFragment();
        fragment.setFeature(feature);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(this.feature.getLayout(), container, false);
        LinearLayout insertPoint = view.findViewById(this.feature.getInsertion_point());

        ImageButton lock_all = view.findViewById(R.id.global_lock_toggle);
        // notify all rooms about the update
        lock_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Room> rooms = feature.getRooms();
                for(int i = 0; i < rooms.size(); i++) {
                    Room room = rooms.get(i);
                    room.notifyChildren(true);
                }
            }
        });


        View[] views = this.feature.render();

        for(int i = 0; i < views.length; i++) {
            insertPoint.addView(views[i]);
        }

        return view;
    }
}
