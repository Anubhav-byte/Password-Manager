package com.example.hacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Save extends AppCompatActivity {
    private EditText website;
    private EditText user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        website=findViewById(R.id.website);
        user=findViewById(R.id.UId);
    }

    public void back(View view) {
        Intent intent= new Intent(Save.this, MainActivity2.class);
        startActivity(intent);
    }

    public void save(View view) {
        Intent intent=getIntent();
        String password= intent.getStringExtra("password");
        String websites=String.valueOf(website.getText());
        String uid=String.valueOf(user.getText());

        Dbmanager db= new Dbmanager(this);
        String res=db.addRecord(uid,websites,password);

        Toast.makeText(this,res,Toast.LENGTH_LONG).show();
    }
}