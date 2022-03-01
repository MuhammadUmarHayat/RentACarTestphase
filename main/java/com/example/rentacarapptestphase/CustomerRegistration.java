package com.example.rentacarapptestphase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerRegistration extends AppCompatActivity {
//etNameCS,etUsernameCS,etPwCS,etEmailCS,etMobileNoCS,etAddressCS
    //btnCSRegistration,btnLogin2
    //TvStatusCS
    EditText etNameCS1,etUsernameCS1,etPwCS1,etEmailCS1,etMobileNoCS1,etAddressCS1;
    Button btnCSRegistration1,btnLogin21;
    TextView TvStatusCS1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        Customer_Table customer_table=new Customer_Table(this);
       // Customer customer;//=new Customer();

        etNameCS1= (EditText) findViewById(R.id.etNameCS);
        etUsernameCS1 = (EditText) findViewById(R.id.etUsernameCS);
        etPwCS1= (EditText) findViewById(R.id.etPwCS);
        etEmailCS1= (EditText) findViewById(R.id.etEmailCS);
        etMobileNoCS1= (EditText) findViewById(R.id.etMobileNoCS);
        etAddressCS1= (EditText) findViewById(R.id.etAddressCS);

        TvStatusCS1 = (TextView) findViewById(R.id.TvStatusCS);
        btnCSRegistration1  = (Button) findViewById(R.id.btnCSRegistration);
        btnLogin21 = (Button) findViewById(R.id.btnLogin2);
        btnLogin21 = (Button) findViewById(R.id.btnLogin2);


        btnCSRegistration1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

              String  setNameCS,setUsernameCS,setPwCS,setEmailCS,setMobileNoCS,setAddressCS;

                setNameCS= etNameCS1.getText().toString();
                        setUsernameCS=etUsernameCS1.getText().toString();
                setPwCS =etPwCS1.getText().toString();
                        setEmailCS=etEmailCS1.getText().toString();
                setMobileNoCS=etMobileNoCS1.getText().toString();
                        setAddressCS=etAddressCS1.getText().toString();
                        String status="ok";
              Customer  customer=new Customer(setNameCS,setUsernameCS,setPwCS,setEmailCS,setMobileNoCS,setAddressCS,status);

                     if(  customer_table.Register(customer))
                     {

                         Toast.makeText(CustomerRegistration.this, "Customer is registered successfully ", Toast.LENGTH_SHORT).show();
                     }
                     else
                     {
                         Toast.makeText(CustomerRegistration.this, "Error: Something is wrong ", Toast.LENGTH_SHORT).show();

                     }









            }
        });

        btnLogin21.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent page = new Intent(CustomerRegistration.this, MainActivity.class);
                startActivity(page);

            }
        });



    }
}