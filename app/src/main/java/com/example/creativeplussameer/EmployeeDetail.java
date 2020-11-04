package com.example.creativeplussameer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeDetail extends AppCompatActivity  {

    TextView txt_name,txt_email,txt_phone,txt_country,txt_dob;
    Button btn_back;
    EmployeeDetails employeeDetails;
    String name ;
    String Email ;
    String phone ;
    String country ;
    String dob,dob1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        employeeDetails = new EmployeeDetails();
        txt_name = findViewById(R.id.txt_name);
        txt_email = findViewById(R.id.txt_email);
        txt_phone = findViewById(R.id.txt_phone);
        txt_country = findViewById(R.id.txt_country);
        txt_dob = findViewById(R.id.txt_dob);
        btn_back = findViewById(R.id.btn_back);
//        EmployeeDetails.LstEmployee  = getIntent().getSerializableExtra("response");
//        String response =  getIntent().getStringExtra("response");
        Bundle b = this.getIntent().getExtras();
        if (b!=null){
             name = b.getString("name");
             Email =  b.getString("Email");
             phone =  b.getString("phone");
             country =  b.getString("country");
             dob1 =   b.getString("dob");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
        // Convert input string into a date
        DateFormat inputFormat = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
        try {
            Date date = inputFormat.parse(dob1);
            // Format date into output format
            DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
            dob = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        setData();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    private void setData() {
        txt_name.setText(name);
        txt_country.setText(country);
        txt_dob.setText(dob);
        txt_email.setText(Email);
        txt_phone.setText(phone);
    }


}