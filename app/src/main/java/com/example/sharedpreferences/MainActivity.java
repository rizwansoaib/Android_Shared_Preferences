package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText user;
    EditText pwd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user=findViewById(R.id.username);
        pwd=findViewById(R.id.pwd);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh=getSharedPreferences("mysharedpref",MODE_PRIVATE);
        String s1=sh.getString("username","");
        String s2=sh.getString("pwd","");

        user.setText(s1);
        pwd.setText(s2);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sh=getSharedPreferences("mysharedpref",MODE_PRIVATE);
        SharedPreferences.Editor myedit=sh.edit();

        myedit.putString("username",user.getText().toString());
        myedit.putString("pwd",pwd.getText().toString());

        myedit.apply();

    }
}