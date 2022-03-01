package com.example.rentacarapptestphase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManagerRegistration extends AppCompatActivity {
    EditText etNameCS1,etUsernameCS1,etPwCS1,etEmailCS1,etMobileNoCS1,etAddressCS1;
    Button btnCSRegistration1,btnbakc;
    TextView TvStatusCS1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_registration);

      //  Customer_Table customer_table=new Customer_Table(this);
        // Customer customer;//=new Customer();
        Manager_Table mgtTble=new Manager_Table(this);

        etNameCS1= (EditText) findViewById(R.id.etNameCSMgr);
        etUsernameCS1 = (EditText) findViewById(R.id.etUsernameCSMgr);
        etPwCS1= (EditText) findViewById(R.id.etPwCSMgr);
        etEmailCS1= (EditText) findViewById(R.id.etEmailCSMgr);
        etMobileNoCS1= (EditText) findViewById(R.id.etMobileNoCSMgr);
        etAddressCS1= (EditText) findViewById(R.id.etAddressCSMgr);

        TvStatusCS1 = (TextView) findViewById(R.id.TvStatusCSMgr);
        btnCSRegistration1  = (Button) findViewById(R.id.btnCSRegistrationMgr);

        btnbakc = (Button) findViewById(R.id.btnBakManagerMgr);


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
               // Customer  customer=new Customer(setNameCS,setUsernameCS,setPwCS,setEmailCS,setMobileNoCS,setAddressCS,status);
Manager manager=new Manager(setNameCS,setUsernameCS,setPwCS,setEmailCS,setMobileNoCS,setAddressCS,status);
                if(  mgtTble.Register(manager))
                {

                    Toast.makeText(ManagerRegistration.this, "Customer is registered successfully ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ManagerRegistration.this, "Error: Something is wrong ", Toast.LENGTH_SHORT).show();

                }









            }
        });

        btnbakc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent page = new Intent(ManagerRegistration.this, MainActivity.class);
                startActivity(page);

            }
        });



    }
}