package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class user_hs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hs);

        Button btn1 = (Button) findViewById(R.id.ViewProfBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_hs.this, user_prof_screen.class));
            }
        });

        Button btn2 = (Button) findViewById(R.id.MakeResBtn);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_hs.this, MakeReservationScreen.class));
            }
        });

        Button btn3 = (Button) findViewById(R.id.ViewResBtn);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_hs.this, view_reservation_screen.class));
            }
        });

        Button btn4 = (Button) findViewById(R.id.ViewPastResBtn);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_hs.this, view_past_reservations_screen.class));
            }
        });

        Button btn5 = (Button) findViewById(R.id.ViewNoShowBtn);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_hs.this, view_no_show_screen.class));
            }
        });

        Button btn6 = (Button) findViewById(R.id.ViewViolBtn);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_hs.this, view_violation_screen.class));
            }
        });

    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
