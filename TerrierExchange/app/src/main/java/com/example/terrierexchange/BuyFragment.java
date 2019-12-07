package com.example.terrierexchange;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        casbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //BuyCasFragment buyCasFragment = new BuyCasFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout,new BuyCasFragment());
                transaction.commit();
            }
        });

        Button kilachandbutton = (Button) view.findViewById(R.id.kilachandbutton);
        kilachandbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //BuyKilachandFragment buyKilachandFragment = new BuyKilachandFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout,new BuyKilachandFragment());
                transaction.commit();
            }
        });

        Button combutton = (Button) view.findViewById(R.id.combutton);
        combutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //BuyComFragment buyComFragment = new BuyComFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout,new BuyComFragment());
                transaction.commit();
            }
        });

        Button cgsbutton = (Button) view.findViewById(R.id.cgsbutton);
        cgsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //BuyComFragment buyCgsFragment = new BuyCgsFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout,new BuyCgsFragment());
                transaction.commit();
            }
        });

        Button engbutton = (Button) view.findViewById(R.id.engbutton);
        engbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //BuyEngFragment buyEngFragment = new BuyEngFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout,new BuyEngFragment());
                transaction.commit();
            }
        });

        Button shabutton = (Button) view.findViewById(R.id.shabutton);
        shabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //BuyEngFragment buyShaFragment = new BuyShaFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout,new BuyShaFragment());
                transaction.commit();
            }
        });

        Button qstbutton = (Button) view.findViewById(R.id.qstbutton);
        qstbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //BuyQstFragment buyEngFragment = new BuyQstFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout,new BuyQstFragment());
                transaction.commit();
            }
        });

        Button sarbutton = (Button) view.findViewById(R.id.sarbutton);
        sarbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //BuyEngFragment buySarFragment = new BuySarFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout,new BuySarFragment());
                transaction.commit();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
