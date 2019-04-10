package com.example.myapplication1.com.cse5324.team6.admin;

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

import com.example.myapplication1.R;

public class AdminEditUserProfile extends AppCompatActivity {

    public static Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_user_profile);

        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner mySpinner1 = (Spinner) findViewById(R.id.UTspinner1);


        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.UserTypes));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner1.setAdapter(myAdapter1);

    }

    public void test8(View view) {
        btn1 = (Button) findViewById(R.id.Savebtn12);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(AdminEditUserProfile.this);
                build1.setMessage("Do you want to save the changes ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"The Profile has been updated",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"The Profile has not been updated",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm update profile");
                alert.show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
