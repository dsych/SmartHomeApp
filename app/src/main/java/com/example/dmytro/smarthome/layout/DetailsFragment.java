package com.example.dmytro.smarthome.layout;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dmytro.smarthome.Feature;
import com.example.dmytro.smarthome.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {
    Feature feature;

    public DetailsFragment() {
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
    public static DetailsFragment newInstance(Feature feature) {
        DetailsFragment fragment = new DetailsFragment();
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
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        LinearLayout insertPoint = view.findViewById(R.id.detailsContent);

        View[] views = this.feature.render();

        for(int i = 0; i < views.length; i++) {
            insertPoint.addView(views[i]);
        }

        return view;
    }

}
