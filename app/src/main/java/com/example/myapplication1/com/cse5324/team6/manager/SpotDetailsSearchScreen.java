package com.example.myapplication1.com.cse5324.team6.manager;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.myapplication1.com.cse5324.team6.controller.SpotController;
import com.example.myapplication1.com.cse5324.team6.util.*;

import com.example.myapplication1.R;
import android.util.Log;

import java.text.SimpleDateFormat;

public class SpotDetailsSearchScreen extends AppCompatActivity {

    public static Button btn1;
    public static Button btn2;
    private Button btnSearch;
    private SpotController spotController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_details_search_screen);
        spotController = new SpotController();

        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Spinner mySpinner1 = (Spinner) findViewById(R.id.PTs1);
        final Spinner mySpinner2 = (Spinner) findViewById(R.id.ANs2);
        final Spinner mySpinner3 = (Spinner) findViewById(R.id.Fls3);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingTypes));
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ParkingAreaNames));
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Floor));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner1.setAdapter(myAdapter);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner3.setAdapter(myAdapter3);

        /* init DB */
        DBMgr.getInstance(this);

        btnSearch = (Button) findViewById(R.id.SearchSpot);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ReservationDetails res = spotController.getReservation("Davis", 1, ParkingType.Basic, 12);
                EditText spotNumber = (EditText) findViewById(R.id.editText51);
                Log.d("Stag", "before");
                String spotNumberStr = spotNumber.getText().toString();
                if ( spotNumberStr.isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "Please fill the spot number", Toast.LENGTH_LONG).show();
                    return;
                }
                ReservationDetails res = spotController.getReservation(
                        mySpinner2.getSelectedItem().toString(),
                        Integer.parseInt(mySpinner3.getSelectedItem().toString()),
                        ParkingType.values()[mySpinner1.getSelectedItemPosition()],
                        Integer.parseInt(spotNumber.getText().toString()));
                Toast.makeText(getApplicationContext(), "PID", Toast.LENGTH_LONG).show();
                Log.d("Stag", Integer.toString(res.getPid()));
                Log.d("Stag", res.getUserName());
                if ( -1 == res.getPid() ) {
                    EditText status = (EditText) findViewById(R.id.SpotStatus);
                    status.setText("Available");
                } else {
                    EditText status = (EditText) findViewById(R.id.SpotStatus);
                    status.setText("Occupied");
                    EditText pid = (EditText) findViewById(R.id.SpotParkingID);
                    status.setText(Integer.toString(res.getPid()));
                    EditText user = (EditText) findViewById(R.id.SpotUserName);
                    user.setText(res.getUserName());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString = dateFormat.format(res.getDate());
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    String startingTimeString = timeFormat.format(res.getDate());
                    String durationString = timeFormat.format(res.getDuration());
                    EditText date = (EditText) findViewById(R.id.editText71);
                    date.setText(dateString);
                    EditText start = (EditText) findViewById(R.id.editText69);
                    start.setText(startingTimeString);
                    EditText duration = (EditText) findViewById(R.id.editText70);
                    duration.setText(durationString);
                }
            }
        });
    }

    public void test6(View view) {
        btn1 = (Button) findViewById(R.id.DelResbtn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(SpotDetailsSearchScreen.this);
                build1.setMessage("Do you want to delete this reservation?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Your reservation has been deleted.",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Your reservation has not been deleted",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm reservation deletion");
                alert.show();
            }
        });
    }

    public void test7(View view) {
        btn2 = (Button) findViewById(R.id.MkSptunavail);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(SpotDetailsSearchScreen.this);
                build1.setMessage("Do you want make the spot unavailable?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"The spot has been made unavailable",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"The spot has not been made unavailable",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm Closure");
                alert.show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
