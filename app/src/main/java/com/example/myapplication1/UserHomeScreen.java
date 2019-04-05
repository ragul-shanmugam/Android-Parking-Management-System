package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class UserHomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hs);

        Button btn1 = (Button) findViewById(R.id.ViewProfBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHomeScreen.this, UserProfileScreen.class));
            }
        });

        Button btn2 = (Button) findViewById(R.id.MakeResBtn);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHomeScreen.this, MakeReservationScreen.class));
            }
        });

        Button btn3 = (Button) findViewById(R.id.ViewResBtn);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHomeScreen.this, ViewReservationScreen.class));
            }
        });

        Button btn4 = (Button) findViewById(R.id.ViewPastResBtn);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHomeScreen.this, ViewPastReservationsScreen.class));
            }
        });

        Button btn5 = (Button) findViewById(R.id.ViewNoShowBtn);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHomeScreen.this, ViewNoShowScreen.class));
            }
        });

        Button btn6 = (Button) findViewById(R.id.ViewViolBtn);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHomeScreen.this, ViewViolationScreen.class));
            }
        });

    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
