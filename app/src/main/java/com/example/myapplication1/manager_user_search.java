package com.example.myapplication1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class manager_user_search extends AppCompatActivity {

    public static Button btn1;
    public static Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_user_search);

    }

    public void test4(View view) {
        btn1 = (Button) findViewById(R.id.snoshowbtn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(manager_user_search.this);
                build1.setMessage("Do you want to set a no show for this reservation ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"The reservation has been set to no show",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"The reservation has not been set to no show",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm No Show");
                alert.show();
            }
        });
    }

    public void test5(View view) {
        btn2 = (Button) findViewById(R.id.sovrbtn1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(manager_user_search.this);
                build1.setMessage("Do you want to set this reservation to overdue ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"The reservation has been set to overdue",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"The reservation has not been set to overdue",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm Overdue");
                alert.show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
