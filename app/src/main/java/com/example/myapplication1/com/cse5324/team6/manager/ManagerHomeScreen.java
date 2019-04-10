package com.example.myapplication1.com.cse5324.team6.manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.myapplication1.R;

public class ManagerHomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgr_hs);

        Button btn1 = (Button) findViewById(R.id.ViewProfBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagerHomeScreen.this, ManagerViewProfile.class));
            }
        });

        Button btn2 = (Button) findViewById(R.id.ViewUserBtn);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagerHomeScreen.this, ManagerUserSearch.class));
            }
        });

        Button btn3 = (Button) findViewById(R.id.ViewSpotDetBtn);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagerHomeScreen.this, SpotDetailsSearchScreen.class));
            }
        });

        Button btn4 = (Button) findViewById(R.id.CheckAvailBtn);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagerHomeScreen.this, AvailabilityScreen.class));
            }
        });


    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
