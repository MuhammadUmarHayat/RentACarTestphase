package com.example.rentacarapptestphase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class StaffRegistration extends AppCompatActivity
{
    EditText etNameCS1,etUsernameCS1,etPwCS1,etEmailCS1,etMobileNoCS1,etAddressCS1;
    Button btnMgrRegistration1,btnback;
    TextView TvStatusCS1;
    Spinner spDesignation;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_registration);

        Staff_Table staff_table=new Staff_Table(this);
        // Customer customer;//=new Customer();

        etNameCS1= (EditText) findViewById(R.id.etNameMgr);
        etUsernameCS1 = (EditText) findViewById(R.id.etUsernameMgr);
        etPwCS1= (EditText) findViewById(R.id.etPwMgr);
        etEmailCS1= (EditText) findViewById(R.id.etEmailMgr);
        etMobileNoCS1= (EditText) findViewById(R.id.etMobileNoMgr);
        etAddressCS1= (EditText) findViewById(R.id.etAddressMgr);

        TvStatusCS1 = (TextView) findViewById(R.id.TvStatusMgr);
        btnMgrRegistration1  = (Button) findViewById(R.id.btnMgrRegistration);

        btnback= (Button) findViewById(R.id.btnbackMgr);
        spDesignation= (Spinner) findViewById(R.id.spDesignationMgr);


        btnMgrRegistration1.setOnClickListener(new View.OnClickListener() {
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
                String designation=spDesignation.getSelectedItem().toString();
              //  Customer  customer=new Customer(setNameCS,setUsernameCS,setPwCS,setEmailCS,setMobileNoCS,setAddressCS,status);
                Staff staff=new Staff(setNameCS,setUsernameCS,setPwCS,setEmailCS,setMobileNoCS,setAddressCS,status,designation);


                if(  staff_table.Register(staff))
                {

                    Toast.makeText(StaffRegistration.this, "Staff is registered successfully ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(StaffRegistration.this, "Error: Something is wrong ", Toast.LENGTH_SHORT).show();

                }









            }
        });

        btnback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent page = new Intent(StaffRegistration.this, ManagerPanel.class);
                startActivity(page);

            }
        });



    }
}