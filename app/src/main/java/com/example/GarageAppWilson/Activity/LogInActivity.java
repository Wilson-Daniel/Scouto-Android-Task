package com.example.GarageAppWilson.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.GarageAppWilson.MainActivity;
import com.example.GarageAppWilson.R;
import com.example.GarageAppWilson.UserHelperDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LogInActivity extends AppCompatActivity {

    EditText userId;
    EditText passWord;
    TextView sign;
    UserHelperDatabase userHelperDatabase;
    List<com.example.GarageAppWilson.Class.userData> userTable = new ArrayList<>();
    String userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        userId = findViewById(R.id.user);
        passWord = findViewById(R.id.passW);
        sign = findViewById(R.id.sig);

        userHelperDatabase =UserHelperDatabase.getDB(this);
        userTable = userHelperDatabase.userDao().getUserData();
        ArrayList<com.example.GarageAppWilson.Class.userData> userDB = (ArrayList<com.example.GarageAppWilson.Class.userData>) userHelperDatabase.userDao().getUserData();



        final String[] matchId = new String[1];


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNum;
                String pass;
                userNum = Objects.requireNonNull(userId.getText()).toString();
                pass = Objects.requireNonNull(passWord.getText()).toString();
                if(!userNum.equals("") && !pass.equals("")) {
                    for(int i=0; i<userDB.size(); i++) {
                        userData = userDB.get(i).getUserid();
                        if (userNum.equals(userData)) {
                            matchId[0] = userDB.get(i).getPassword();
                            if (matchId[0].equals(pass)) {
                                Toast.makeText(LogInActivity.this, "Successful.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                }

            }
        });


    }
}