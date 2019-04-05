package com.example.myapplication1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminSearchUser extends AppCompatActivity {

    public static Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_search_user);

        Button btn1 = (Button) findViewById(R.id.Editbtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminSearchUser.this, AdminEditUserProfile.class));
            }
        });

    }

    public void test9(View view) {
        btn2 = (Button) findViewById(R.id.RevokeUserbtn1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build1 = new AlertDialog.Builder(AdminSearchUser.this);
                build1.setMessage("Do you want to revoke this user ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"The user has been revoked",Toast.LENGTH_LONG).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"The user has not been revoked",Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = build1.create();
                alert.setTitle("Confirm Revoke");
                alert.show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
