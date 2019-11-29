package com.example.terrierexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create button objects for MainActivity page
        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        // if clicks login button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // make an Intent object for login page
                Intent loginIntent = new Intent(getApplicationContext(), LoginPage.class);
                // route the user to login page
                startActivity(loginIntent);
            }
        });

        // create button object for Registration page
        Button registerBtn = (Button) findViewById(R.id.registerBtn);
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
