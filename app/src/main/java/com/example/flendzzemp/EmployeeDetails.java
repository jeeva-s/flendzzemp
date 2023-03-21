package com.example.flendzzemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Locale;
import java.util.Map;

public class EmployeeDetails extends AppCompatActivity {
    TextView name,email,id,address,companyaddress,phone,website;

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
        website=findViewById(R.id.websiteDetails);
        Bundle intent=getIntent().getExtras();
        String camelCase=UpperCamel.convertString(intent.get("name").toString());
       // String camelCase = CaseUtils.toCamelCase(text, true, delimiter);
        name.setText("Name : "+camelCase);
        email.setText("Email : "+intent.get("email").toString().toLowerCase(Locale.ROOT));
        id.setText("Employee Id : "+intent.get("id").toString());
        phone.setText("Phone Number : "+intent.get("phone").toString());
        address.setText("Address : "+intent.get("address").toString());
        website.setText("Website : "+intent.get("website").toString());
        companyaddress.setText("Company Name : "+intent.get("companyAddress").toString());
       // Toast.makeText(this, ""+intent.getExtras().get("name").toString(), Toast.LENGTH_SHORT).show();
    }
}