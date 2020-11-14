package com.example.hacks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Main Activity","Hello");
    }


    public void Gpassword(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }

    public void viewdatabase(View view) {
        Intent intent= new Intent(MainActivity.this, PassView.class);
        startActivity(intent);

    }

    public void close(View view) {
        finish();
    }
}