package com.example.letcommute.Fragments;

import static java.util.Arrays.asList;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.letcommute.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrackFragment extends Fragment {

    ListView listView;
    String[] routes = {"Home ➡ Work", "Work ➡ Home", "Work ➡ Lunch", "Home ➡ Gym", "Gym ➡ Dinner"};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrackFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrackFragment newInstance(String param1, String param2) {
        TrackFragment fragment = new TrackFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_track, container, false);
        listView = view.findViewById(R.id.listview);
        ArrayList<String> data = new ArrayList<String>(Arrays.asList(routes));
        MyAdapter adapter = new MyAdapter(getContext(), data);
        listView.setAdapter(adapter);
        return view;
    }
}

class MyAdapter extends ArrayAdapter<String> {
    public MyAdapter(Context context, ArrayList<String> data) {
        super(context, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_track, parent, false);
        }

        // Set data to views in list_item layout
        TextView textView = convertView.findViewById(R.id.textview);
        textView.setText(getItem(position));

        return convertView;
    }
}