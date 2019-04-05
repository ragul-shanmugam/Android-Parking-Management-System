package com.example.myapplication1;

import android.app.ActionBar;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserRegistrationScreen extends AppCompatActivity {

    private EditText Fname,Lname,Username,Password,Rpassword,UTAid,Phno,Email,Carinfo,Licenseno;
    private Spinner Parktype,Usertype;
    private Button Register;
    SQLiteDatabase Db;
    public static int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_user_registration_screen);
        super.onCreate(savedInstanceState);


        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        UISetupViews();

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Permit));
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.UserTypes));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Parktype.setAdapter(myAdapter1);
        Usertype.setAdapter(myAdapter2);

        //validatepass();



        Usertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String Usertype1 = Usertype.getSelectedItem().toString();
                if ((Usertype1.equals("Manager") || Usertype1.equals("Admin"))){
                    //Carinfo.setFocusable(false);
                    Carinfo.setEnabled(false);
                    Licenseno.setEnabled(false);
                    //Licenseno.setFocusable(false);
                }
                else{

                 //   Carinfo.setFocusable(true);
                    Carinfo.setEnabled(true);
                    Licenseno.setEnabled(true);
                   // Licenseno.setFocusable(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button Register = (Button) findViewById(R.id.btnRegister);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validatedetails()){

                        insertdata();
                }//else{
                   // Toast.makeText(getApplicationContext(),"The ",Toast.LENGTH_LONG).show();
                //}
            }
        });
    }

    private void UISetupViews(){
        Fname = (EditText)findViewById(R.id.etFName);
        Lname = (EditText)findViewById(R.id.etLName);
        Username = (EditText)findViewById(R.id.etUsername);
        Password = (EditText)findViewById(R.id.etPassword);
        Rpassword = (EditText)findViewById(R.id.etRPassword);
        UTAid = (EditText)findViewById(R.id.etUTAid);
        Phno = (EditText)findViewById(R.id.etPHno);
        Email = (EditText)findViewById(R.id.etEmail);
        Carinfo = (EditText)findViewById(R.id.etCarinfo);
        Licenseno = (EditText)findViewById(R.id.etLicenseno);
        Parktype = (Spinner) findViewById(R.id.PermitTSpinner1);
        Usertype = (Spinner) findViewById(R.id.UserTspinner2);
    }



    private Boolean validatedetails(){
        Boolean result = false;

        String Fname1 = Fname.getText().toString();
        String Lname1 = Lname.getText().toString();
        String Username1 = Username.getText().toString();
        String Password1 = Password.getText().toString();
        String RPassword1 = Rpassword.getText().toString();
        String UTAid1 = UTAid.getText().toString();
        String Phno1 = Phno.getText().toString();
        String Email1 = Email.getText().toString();
        String Carinfo1 = Carinfo.getText().toString();
        String Licenseno1 = Licenseno.getText().toString();
        String Parktype1 = Parktype.getSelectedItem().toString();
        String Usertype1 = Usertype.getSelectedItem().toString();

        /*if (!(Usertype1.equals("Parking Manager") && Usertype1.equals("Admin"))){
            Carinfo.setFocusable(true);
            Carinfo.setEnabled(true);
            Licenseno.setEnabled(true);
            Licenseno.setFocusable(true);
        }*/
        validatepass();



        if (Fname1.isEmpty() || Lname1.isEmpty() || Username1.isEmpty() || Password1.isEmpty() || RPassword1.isEmpty() || UTAid1.isEmpty() || Phno1.isEmpty() || Email1.isEmpty() || Carinfo1.isEmpty() || Licenseno1.isEmpty()){
            Toast.makeText(this,"Please enter all the details",Toast.LENGTH_LONG).show();
        }
        else if(!Email1.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            Toast.makeText(this,"Enter correct email format",Toast.LENGTH_LONG).show();
        }
        else{
            result = true;
        }
        return  result;
    }
    private void validatepass(){
        if (!(Password.getText().toString().equals(Rpassword.getText().toString()))){
            Toast.makeText(this,"The Passwords do not match. Please Re-type the password",Toast.LENGTH_LONG).show();
        }
    }

    public void insertdata(){
      //  Toast.makeText(this,"h",Toast.LENGTH_LONG).show();

        String Fname1 = Fname.getText().toString();
        String Lname1 = Lname.getText().toString();
        String Username1 = Username.getText().toString();
        String Password1 = Password.getText().toString();
        String RPassword1 = Rpassword.getText().toString();
        String UTAid1 = UTAid.getText().toString();
        String Phno1 = Phno.getText().toString();
        String Email1 = Email.getText().toString();
        String Usertype1 = Usertype.getSelectedItem().toString();
        String Carinfo1,Licenseno1,Parktype1;
        if(Usertype1.equals("User")) {
             Carinfo1 = Carinfo.getText().toString();
             Licenseno1 = Licenseno.getText().toString();
             Parktype1 = Parktype.getSelectedItem().toString();
        }
        else
        {
            Carinfo1="None";
            Licenseno1="None";
            Parktype1="None";
        }
        //Toast.makeText(this,"h",Toast.LENGTH_LONG).show();


        //SQLiteDatabase Db1 = SQLiteDatabase.openOrCreateDatabase("Re",null,null);
        Db=openOrCreateDatabase("Reg", Context.MODE_PRIVATE, null);

        Db.execSQL("CREATE TABLE reg(fname varchar(20),lname varchar(20),username varchar(20),password varchar(20)," +
                "UTAID varchar(20),phone varchar(20),email varchar(30),usertype varchar(10)," +
                "parkingtype varchar(30),carinfo varchar(20),licenseno varchar(20) );");


        Db.execSQL("INSERT INTO reg VALUES('"+Fname1+"','"+Lname1+"','"+Username1+"','"+Password1+"','"+UTAid1+"','"+Phno1+"','"+Email1+"','"+Usertype1+"','"+Parktype1+"','"+Carinfo1+"','"+Licenseno1+"'); ");

        Toast.makeText(this,"You have successfully registered!!",Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_user_registration_screen);
    }

}
