package com.example.GarageAppWilson.Class;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.GarageAppWilson.Activity.LogInActivity;
import com.example.GarageAppWilson.MainActivity;
import com.example.GarageAppWilson.R;
import com.example.GarageAppWilson.UserHelperDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class signUp extends AppCompatActivity {
    ConstraintLayout signUp;
    EditText userId;
    EditText email;
    EditText passWord;
    TextView signIn;
    UserHelperDatabase userHelperDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userHelperDatabase =UserHelperDatabase.getDB(this);


        signUp = findViewById(R.id.signup);
        userId = findViewById(R.id.user);
        email = findViewById(R.id.email);
        passWord = findViewById(R.id.password_input);
        signIn = findViewById(R.id.signin);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uId;
                String mail;
                String pass;
                uId = Objects.requireNonNull(userId.getText()).toString();
                mail = Objects.requireNonNull(email.getText()).toString();
                pass = Objects.requireNonNull(passWord.getText()).toString();

                if(!userId.getText().toString().equals("") && !email.getText().toString().equals("") && !passWord.getText().toString().equals("")) {
                    userHelperDatabase.userDao().addUser(new userData(uId, mail, pass));
                    Toast.makeText(com.example.GarageAppWilson.Class.signUp.this, "User Registered.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(com.example.GarageAppWilson.Class.signUp.this, "Enter UserId, Email, Password.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                startActivity(intent);

            }
        });


    }
}