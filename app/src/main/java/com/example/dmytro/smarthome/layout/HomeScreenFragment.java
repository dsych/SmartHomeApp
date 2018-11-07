package com.example.dmytro.smarthome.layout;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.List;

import com.example.dmytro.smarthome.Room;
import  com.example.dmytro.smarthome.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeScreenFragment extends Fragment {
    List<Room> rooms;
    int margins = 30;
    final int POSITION_TAG = R.id.activity_main;

    public HomeScreenFragment() {
        // Required empty public constructor
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param rooms List of all rooms on the screen.
     * @return A new instance of fragment HomeScreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeScreenFragment newInstance(List<Room> rooms) {
        HomeScreenFragment fragment = new HomeScreenFragment();
        fragment.setRooms(rooms);
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
        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);

        GridLayout grid = view.findViewById(R.id.gridLayout);

        Button roomTile;

        for (int i = 0; i < this.rooms.size(); i++) {
            roomTile = new Button(getContext());
            roomTile.setText(this.rooms.get(i).getName());
            roomTile.setBackgroundResource(R.drawable.button_selector);
            roomTile.setTag(this.POSITION_TAG, i);
            roomTile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = (int)view.getTag(POSITION_TAG);
                    FragmentManager fragmentManager = getActivity().getFragmentManager();
                    DetailsFragment fragment = DetailsFragment.newInstance(rooms.get(index));
                    fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack("details").commit();
                }
            });


            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rightMargin = this.margins;
            params.bottomMargin = this.margins;
            params.leftMargin = this.margins;
            params.topMargin = this.margins;
            params.columnSpec = GridLayout.spec(i % 2 > 0 ? 1 : 0);
            params.rowSpec = GridLayout.spec(i / 2);
            params.setGravity(Gravity.CENTER);
            params.height = 250;
            params.width = 400;


            roomTile.setLayoutParams(params);
            grid.addView(roomTile);
        }

        return view;
    }

}
