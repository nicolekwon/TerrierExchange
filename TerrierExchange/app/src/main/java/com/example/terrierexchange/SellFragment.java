package com.example.terrierexchange;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class SellFragment extends Fragment {
    FirebaseAuth fAuth;
    FirebaseFirestore db;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri mImageUri;
    ImageView image_view;


    public SellFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_sell, container, false);
        // declare a spinner object for dropdown menu
        final Spinner spinner = (Spinner) view.findViewById(R.id.college_spinner);
        // declare EditText object for textbook name, price, description
        final EditText bookName = (EditText) view.findViewById(R.id.textbook_name_input);
        final EditText bookPrice = (EditText) view.findViewById(R.id.text_book_price_input);
        final EditText bookDescription = (EditText) view.findViewById(R.id.description_input);
        final Button uploadBtn = (Button) view.findViewById(R.id.button_upload);
        final Button imageBtn = (Button) view.findViewById(R.id.button_choose_image);
        final Activity activity = getActivity();
        // make an adapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.colleges));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);

        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 image_view = (ImageView) view.findViewById(R.id.image_view);
                openFileChooser();
            }
        });


        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the dropdown value
                String collegeName = spinner.getSelectedItem().toString();
                db = FirebaseFirestore.getInstance();

                if (collegeName.equals("CAS"))
                {
                    Map < String, Object > newBook = new HashMap < > ();
                    newBook.put("textbook_name", bookName.getText().toString());
                    newBook.put("textbook_price", bookPrice.getText().toString());
                    newBook.put("textbook_description", bookDescription.getText().toString());
                    newBook.put("textbook_imageUrl", mImageUri.toString());
                    db.collection("cas_books").document(bookName.getText().toString()).set(newBook)
                            .addOnSuccessListener(new OnSuccessListener < Void > () {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(activity, "Item added",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(activity, "ERROR" + e.toString(),
                                            Toast.LENGTH_SHORT).show();
                                    Log.d("TAG", e.toString());
                                }
                            });
                }
                else if (collegeName.equals("CGS"))
                {
                    Map < String, Object > newBook = new HashMap < > ();
                    newBook.put("textbook_name", bookName.getText().toString());
                    newBook.put("textbook_price", bookPrice.getText().toString());
                    newBook.put("textbook_description", bookDescription.getText().toString());
                    newBook.put("textbook_imageUrl", mImageUri.toString());
                    db.collection("cgs_books").document(bookName.getText().toString()).set(newBook)
                            .addOnSuccessListener(new OnSuccessListener < Void > () {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(activity, "Item added",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(activity, "ERROR" + e.toString(),
                                            Toast.LENGTH_SHORT).show();
                                    Log.d("TAG", e.toString());
                                }
                            });
                }
                else if (collegeName.equals("COM"))
                {
                    Map < String, Object > newBook = new HashMap < > ();
                    newBook.put("textbook_name", bookName.getText().toString());
                    newBook.put("textbook_price", bookPrice.getText().toString());
                    newBook.put("textbook_description", bookDescription.getText().toString());
                    newBook.put("textbook_imageUrl", mImageUri.toString());
                    db.collection("com_books").document(bookName.getText().toString()).set(newBook)
                            .addOnSuccessListener(new OnSuccessListener < Void > () {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(activity, "Item added",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(activity, "ERROR" + e.toString(),
                                            Toast.LENGTH_SHORT).show();
                                    Log.d("TAG", e.toString());
                                }
                            });
                }
                else if (collegeName.equals("ENG"))
                {
                    Map < String, Object > newBook = new HashMap < > ();
                    newBook.put("textbook_name", bookName.getText().toString());
                    newBook.put("textbook_price", bookPrice.getText().toString());
                    newBook.put("textbook_description", bookDescription.getText().toString());
                    newBook.put("textbook_imageUrl", mImageUri.toString());
                    db.collection("eng_books").document(bookName.getText().toString()).set(newBook)
                            .addOnSuccessListener(new OnSuccessListener < Void > () {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(activity, "Item added",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(activity, "ERROR" + e.toString(),
                                            Toast.LENGTH_SHORT).show();
                                    Log.d("TAG", e.toString());
                                }
                            });
                }
                else if (collegeName.equals("KILACHAND"))
                {
                    Map < String, Object > newBook = new HashMap < > ();
                    newBook.put("textbook_name", bookName.getText().toString());
                    newBook.put("textbook_price", bookPrice.getText().toString());
                    newBook.put("textbook_description", bookDescription.getText().toString());
                    newBook.put("textbook_imageUrl", mImageUri.toString());
                    db.collection("kilachand_books").document(bookName.getText().toString()).set(newBook)
                            .addOnSuccessListener(new OnSuccessListener < Void > () {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(activity, "Item added",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(activity, "ERROR" + e.toString(),
                                            Toast.LENGTH_SHORT).show();
                                    Log.d("TAG", e.toString());
                                }
                            });
                }
                else if (collegeName.equals("QST"))
                {
                    Map < String, Object > newBook = new HashMap < > ();
                    newBook.put("textbook_name", bookName.getText().toString());
                    newBook.put("textbook_price", bookPrice.getText().toString());
                    newBook.put("textbook_description", bookDescription.getText().toString());
                    newBook.put("textbook_imageUrl", mImageUri.toString());
                    db.collection("qst_books").document(bookName.getText().toString()).set(newBook)
                            .addOnSuccessListener(new OnSuccessListener < Void > () {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(activity, "Item added",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(activity, "ERROR" + e.toString(),
                                            Toast.LENGTH_SHORT).show();
                                    Log.d("TAG", e.toString());
                                }
                            });
                }
                else if (collegeName.equals("SAR"))
                {
                    Map < String, Object > newBook = new HashMap < > ();
                    newBook.put("textbook_name", bookName.getText().toString());
                    newBook.put("textbook_price", bookPrice.getText().toString());
                    newBook.put("textbook_description", bookDescription.getText().toString());
                    newBook.put("textbook_imageUrl", mImageUri.toString());
                    db.collection("sar_books").document(bookName.getText().toString()).set(newBook)
                            .addOnSuccessListener(new OnSuccessListener < Void > () {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(activity, "Item added",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(activity, "ERROR" + e.toString(),
                                            Toast.LENGTH_SHORT).show();
                                    Log.d("TAG", e.toString());
                                }
                            });
                }
                else if (collegeName.equals("SHA"))
                {
                    Map < String, Object > newBook = new HashMap < > ();
                    newBook.put("textbook_name", bookName.getText().toString());
                    newBook.put("textbook_price", bookPrice.getText().toString());
                    newBook.put("textbook_description", bookDescription.getText().toString());
                    newBook.put("textbook_imageUrl", mImageUri.toString());
                    db.collection("sha_books").document(bookName.getText().toString()).set(newBook)
                            .addOnSuccessListener(new OnSuccessListener < Void > () {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(activity, "Item added",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(activity, "ERROR" + e.toString(),
                                            Toast.LENGTH_SHORT).show();
                                    Log.d("TAG", e.toString());
                                }
                            });
                }
            }
        });

        return view;
    }
    private void openFileChooser()
    {
        Intent intent = new Intent();
        // only see image in file chooser
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null)
        {
            mImageUri = data.getData();
            Picasso.with(getActivity()).load(mImageUri).into(image_view);
        }
    }
}

