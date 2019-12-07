package com.example.terrierexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    // declare objects
    EditText emailInput, passwordInput;
    Button loginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize button objects for login page
        loginBtn = findViewById(R.id.loginBtn);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        fAuth = FirebaseAuth.getInstance();
        // if clicks login button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the email and password input from user
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                // check input validation
                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    emailInput.setError("Email is Required.");
                    passwordInput.setError("Password is Required.");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    emailInput.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    passwordInput.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    passwordInput.setError("Password Must be >= 6 Characters");
                    return;
                }

                // authenticate the user
                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            // route the user to dashboard by making new intent object for dashboard
                            startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        }else {
                            Toast.makeText(MainActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        // initialize button object for Registration page
        Button registerBtn = findViewById(R.id.registerBtn);
        // if clicks register button
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // make an Intent object for register page
                Intent registerIntent = new Intent(getApplicationContext(), RegisterPage.class);
                // route the user to register page
                startActivity(registerIntent);
            }
        });
    }
}
