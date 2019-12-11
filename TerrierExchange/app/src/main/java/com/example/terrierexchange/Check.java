package com.example.terrierexchange;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Check extends Fragment {


    public Check() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_check, container, false);
        Button purchase_btn = (Button) view.findViewById(R.id.purchase_btn);
        purchase_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //BuyCasFragment buyCasFragment = new BuyCasFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout,new final_confirmation());
                transaction.commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
