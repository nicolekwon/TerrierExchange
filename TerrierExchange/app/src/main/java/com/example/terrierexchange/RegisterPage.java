package com.example.terrierexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterPage extends AppCompatActivity {
    // declare needed objects
    public static final String TAG = "TAG";
    EditText nameInput, emailInput, passwordInput;
    Button registerBtn;
    // TextView mLoginBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        // initialize needed objects
        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        registerBtn = findViewById(R.id.registerBtn);
        // mLoginBtn = findViewById(R.id.createText);

        // create firebase authentication objects
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        // if current user exists, redirect to login
        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        // if user clicks register button
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // final keyword means const
                // get the user input information for registration
                final String email = emailInput.getText().toString().trim(); // trim eliminates leading and trailing whitespaces
                String password = passwordInput.getText().toString().trim();
                final String fullName = nameInput.getText().toString();

                // if email and password input is empty, display errors to user
                if (TextUtils.isEmpty((email)) && TextUtils.isEmpty((password))) {
                    emailInput.setError("Email is required.");
                    passwordInput.setError("Password is required.");
                    return;
                }

                // if email input is empty, display an error to user
                if (TextUtils.isEmpty((email))) {
                    emailInput.setError("Email is required.");
                    return;
                }

                // if password input is empty, display an error to user
                if (TextUtils.isEmpty((password))) {
                    passwordInput.setError("Password is required.");
                    return;
                }

                // if password is not greater than 6 char long, display an error
                if (password.length() < 6) {
                    passwordInput.setError("Password Must be >= 6 Characters");
                    return;
                }

                // register the user in firebase
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // if creating user successful, dipslay a short toast message
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterPage.this, "User Created.", Toast.LENGTH_SHORT).show();
                            // get userID from current user
                            userID = fAuth.getCurrentUser().getUid();
                            // find a reference for user in database
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("name", fullName);
                            user.put("email", email);
                            // set reference for user, creating a profile
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user Profile is created for " + userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        } else {
                            Toast.makeText(RegisterPage.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
