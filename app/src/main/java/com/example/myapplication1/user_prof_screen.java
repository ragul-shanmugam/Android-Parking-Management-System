package com.example.myapplication1;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class user_prof_screen extends AppCompatActivity {
    SQLiteDatabase Db;
    private EditText Fname2,Lname2,UTAid2,Phno2,Email2,Carinfo2,Licenseno2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_prof_screen);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        UISetupViews1();
        show();


        Button btn1 = (Button) findViewById(R.id.updateBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(user_prof_screen.this, user_edit_prof_screen.class));
                //show();

            }
        });
        //int b=user_registration_screen.a;
        //Toast.makeText(this,String.valueOf(user_registration_screen.a),Toast.LENGTH_LONG).show();
        //show();

    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void UISetupViews1(){
        Fname2 = (EditText)findViewById(R.id.etFName1);
        Lname2 = (EditText)findViewById(R.id.etLName1);
        UTAid2 = (EditText)findViewById(R.id.etUTAid1);
        Phno2 = (EditText)findViewById(R.id.etPhno1);
        Email2 = (EditText)findViewById(R.id.etEmail1);
        Carinfo2 = (EditText)findViewById(R.id.etCarinfo1);
        Licenseno2 = (EditText)findViewById(R.id.etLicense1);

    }
    public void show(){

        Db=openOrCreateDatabase("Reg", Context.MODE_PRIVATE, null);

        Cursor c = Db.rawQuery("SELECT * FROM  reg;",null);
        if (c !=  null&&c.moveToFirst()){
            Lname2.setText(c.getString(1));
            Fname2.setText(c.getString(0));
            UTAid2.setText(c.getString(4));
            Phno2.setText(c.getString(5));
            Email2.setText(c.getString(6));
            Carinfo2.setText(c.getString(9));
            Licenseno2.setText(c.getString(10));

            c.close();
        }
        else {
            Toast.makeText(this,"No values",Toast.LENGTH_LONG).show();
        }
        //setContentView(R.layout.activity_user_prof_screen);
    }

}
