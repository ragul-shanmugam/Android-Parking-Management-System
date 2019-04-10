package com.example.myapplication1.com.cse5324.team6.manager;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.myapplication1.R;

public class AvailabilityScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability_screen);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner mySpinner10 = (Spinner) findViewById(R.id.ParkTySpin1);
        Spinner mySpinner11 = (Spinner) findViewById(R.id.AreaNspinner2);

        ArrayAdapter<String> myAdapter10 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingTypes));
        ArrayAdapter<String> myAdapter11 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingAreaNames));


        myAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        mySpinner10.setAdapter(myAdapter10);
        mySpinner11.setAdapter(myAdapter11);

    }


    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
