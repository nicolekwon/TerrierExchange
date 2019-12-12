package com.example.terrierexchange;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuyQstFragment extends Fragment {


    public BuyQstFragment() {
        // Required empty public constructor
    }

    ListView listView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_buy_qst, container, false);
        listView = (ListView) view.findViewById(R.id.listviewQST);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("QST example 1");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        // Inflate the layout for this fragment
        return view;
    }

}
