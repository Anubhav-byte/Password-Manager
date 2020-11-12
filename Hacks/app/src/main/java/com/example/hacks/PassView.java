package com.example.hacks;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PassView extends AppCompatActivity {
    private TextView textlabel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_view);
        Dbmanager db=new Dbmanager(this);
        Cursor cs = db.getData();
        textlabel=findViewById(R.id.textView);
        StringBuffer st= new StringBuffer();
        if(cs.getCount()==0){
            Toast.makeText(this,"No database found", Toast.LENGTH_SHORT).show();
        }
        else{

            while(cs.moveToNext()){
                st.append("UserId: "+cs.getString(0)+"\n");
                st.append("Website:  " + cs.getString(1)+"\n");
                st.append("Password: "+ cs.getString(2)+ "\n");
                st.append("\n");
            }
        }
        textlabel.setText(st);
    }
}