package com.example.terrierexchange;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuyCasFragment extends Fragment {


    public BuyCasFragment() {
        // Required empty public constructor
    }

    ListView listView;
    ListView mListView;
    View view;
    FirebaseFirestore db;
    List<String> namesList = new ArrayList<>();
    List<String> priceList = new ArrayList<>();
    List<String> descriptionList = new ArrayList<>();
    List<String> imageList = new ArrayList<>();

    int [] images = {R.drawable.ic_launcher_background,
                     R.drawable.ic_launcher_background,
                     R.drawable.ic_launcher_background,
                     R.drawable.ic_launcher_background,
                     R.drawable.ic_launcher_background,
                     };

    String[] BookNames = {"Book 1" , "Book 2", "Book 3", "Book 4", "Book 5"};

    @Override
   /* public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_buy_cas, container, false);
        listView = view.findViewById(R.id.listviewCAS);
        db = FirebaseFirestore.getInstance();

        db.collection("cas_books").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                namesList.clear();
                priceList.clear();
                descriptionList.clear();
                imageList.clear();

                for (DocumentSnapshot snapshot : queryDocumentSnapshots) {
                    namesList.add(snapshot.getString("textbook_name"));
                    priceList.add(snapshot.getString("textbook_price"));
                    descriptionList.add(snapshot.getString("textbook_description"));
                    imageList.add(snapshot.getString("textbook_imageUrl"));
                }


                List<HashMap<String, String>> aList = new ArrayList<>();

                for (int i = 0; i < namesList.size(); i++)
                {
                    ListIterator<String> name_iterator = namesList.listIterator(i);
                    ListIterator<String> price_iterator = namesList.listIterator(i);
                    ListIterator<String> des_iterator = namesList.listIterator(i);
                    ListIterator<String> image_iterator = namesList.listIterator(i);


                    HashMap<String, String> hm = new HashMap<>();
                    hm.put("Title", name_iterator.toString());
                    hm.put("Title", price_iterator.toString());
                    hm.put("Title", des_iterator.toString());
                    hm.put("Title", image_iterator.toString());
                    aList.add(hm);
                }


                ArrayAdapter<HashMap<String, String>> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_selectable_list_item);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);*/

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_buy_cas, container, false);
        return rootView;
    }
            }
       // });

        // Inflate the layout for this fragment
  //      return view;
  //  }

//}