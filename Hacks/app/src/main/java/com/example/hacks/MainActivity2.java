package com.example.hacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private TextView vPassword;
    private EditText plength;
    private String passwords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vPassword= findViewById(R.id.pView);
        plength= findViewById(R.id.plength);
    }
    public void Password(View view){
        int len=Integer.parseInt( String.valueOf(plength.getText()) );
        if(len<8 )
            len=8;
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";


        String values = Capital_chars + Small_chars +
                numbers + symbols;

        // Using random method
        Random rndm_method = new Random();

        char[] password = new char[len];

        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] =
                    values.charAt(rndm_method.nextInt(values.length()));

        }
        passwords=new String(password);
        vPassword.setText(passwords);
    }


    public void back(View view) {
        Intent intent=new Intent(MainActivity2.this , MainActivity.class);
        startActivity(intent);
    }

    public void reset(View view) {
        passwords="";
        vPassword.setText(passwords);
    }
    public void save(View view){
        new Dbmanager(this);
        Intent intent = new Intent(MainActivity2.this, Save.class);
        intent.putExtra("password",passwords );
        startActivity(intent);
    }
}