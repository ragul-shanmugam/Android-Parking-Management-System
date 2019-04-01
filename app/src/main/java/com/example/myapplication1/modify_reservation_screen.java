package com.example.myapplication1;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class modify_reservation_screen extends AppCompatActivity {

    public static Button btn0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_reservation_screen);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner mySpinner1 = (Spinner) findViewById(R.id.PTs1);
        Spinner mySpinner2 = (Spinner) findViewById(R.id.ANs2);
        Spinner mySpinner3 = (Spinner) findViewById(R.id.Fs3);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingTypes));
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingAreaNames));
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Floor));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner1.setAdapter(myAdapter);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner3.setAdapter(myAdapter3);
    }

    public void test3(View view) {
        btn0 = (Button) findViewById(R.id.confirmbtn1);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(modify_reservation_screen.this);
                build1.setMessage("Do you want to confirm the Reservation?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Your reservation has been modified",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Your reservation has not been modified",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm Modification");
                alert.show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
