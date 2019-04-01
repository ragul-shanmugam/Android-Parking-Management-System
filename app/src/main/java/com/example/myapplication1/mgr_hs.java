package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class mgr_hs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgr_hs);

        Button btn1 = (Button) findViewById(R.id.ViewProfBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mgr_hs.this, manager_view_profile.class));
            }
        });

        Button btn2 = (Button) findViewById(R.id.ViewUserBtn);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mgr_hs.this, manager_user_search.class));
            }
        });

        Button btn3 = (Button) findViewById(R.id.ViewSpotDetBtn);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mgr_hs.this, spot_details_search_screen.class));
            }
        });

        Button btn4 = (Button) findViewById(R.id.CheckAvailBtn);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mgr_hs.this, availability_screen.class));
            }
        });


    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
