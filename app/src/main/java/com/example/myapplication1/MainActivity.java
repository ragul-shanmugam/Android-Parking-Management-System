package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Signin;
    private int counter = 5;
    boolean userAvailable;
    LoginController loginController = new LoginController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etUsername);
        Password = (EditText)findViewById(R.id.etPassword);
        Signin = (Button)findViewById(R.id.SignInBtn);


        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         //       validate(Name.getText().toString(),Password.getText().toString());
                startActivity(new Intent(MainActivity.this, AdminHomeScreen.class));
            }
        });

        Button Signup = (Button) findViewById(R.id.SignUpBtn);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserRegistrationScreen.class));
            }
        });

        Button Forgotpass = (Button) findViewById(R.id.ForgotPassBtn);

        Forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForgotPassword.class));
            }
        });
    }

    private void validate(String userName, String userPassword){

        try
        {
            userAvailable = loginController.loginCheck(userName, userPassword);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        if(userAvailable){
            Intent intent = new Intent(MainActivity.this, AdminHomeScreen.class);
            startActivity(intent);
        }
        else {
            counter--;
                Toast.makeText(getApplicationContext(),"You still have " + String.valueOf(counter),Toast.LENGTH_LONG).show();
            if(counter == 0){

              Signin.setEnabled(false);
            }
        }

    }

}
