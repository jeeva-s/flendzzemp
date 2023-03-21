package com.example.flendzzemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Map;

public class EmployeeDetails extends AppCompatActivity {
    TextView name,email,id,address,companyaddress,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_details);
        name=findViewById(R.id.nameDetails);
        email=findViewById(R.id.emailDetails);
        id=findViewById(R.id.idDetails);
        phone=findViewById(R.id.phoneDetails);
        address=findViewById(R.id.addressDetails);
        companyaddress=findViewById(R.id.companyDetails);
        Bundle intent=getIntent().getExtras();
        name.setText("Name :"+intent.get("name").toString());
        email.setText("Email :"+intent.get("email").toString());
        id.setText("Id :"+intent.get("id").toString());
        phone.setText("Phone :"+intent.get("phone").toString());
        address.setText("Address :"+intent.get("address").toString());
        companyaddress.setText("Company Details :"+intent.get("companyAddress").toString());
       // Toast.makeText(this, ""+intent.getExtras().get("name").toString(), Toast.LENGTH_SHORT).show();
    }
}