package com.example.terrierexchange;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuyFragment extends Fragment {


    public BuyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy, container, false);
        Button casbutton = (Button) view.findViewById(R.id.casbutton);
        Button kilachandbutton = (Button) view.findViewById(R.id.kilachandbutton);
        Button combutton = (Button) view.findViewById(R.id.combutton);
        Button cgsbutton = (Button) view.findViewById(R.id.cgsbutton);
        Button engbutton = (Button) view.findViewById(R.id.engbutton);
        Button shabutton = (Button) view.findViewById(R.id.shabutton);
        Button qstbutton = (Button) view.findViewById(R.id.qstbutton);
        Button sarbutton = (Button) view.findViewById(R.id.sarbutton);
        // Inflate the layout for this fragment
        return view;
    }

}
