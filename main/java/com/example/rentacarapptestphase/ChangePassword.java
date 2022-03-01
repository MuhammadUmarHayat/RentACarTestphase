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

public class ChangePassword extends AppCompatActivity
{
Spinner spuserTypeCP1;
EditText etUsernameCP1,etPwOldCP1,etPwNewCP11,etPwNewCP21;
Button btnChangepassword1,btnbackChangepassword1;
   TextView TvRegLoginCP1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        etUsernameCP1 = (EditText) findViewById(R.id.etUsernameCP);
        etPwOldCP1 = (EditText) findViewById(R.id.etPwOldCP);
        etPwNewCP11  = (EditText) findViewById(R.id.etPwNewCP1);
        etPwNewCP21 = (EditText) findViewById(R.id.etPwNewCP2);

        TvRegLoginCP1 = (TextView) findViewById(R.id.TvRegLoginCP);

        spuserTypeCP1=(Spinner)findViewById(R.id.spuserTypeCP) ;//spinner

        btnChangepassword1 = (Button) findViewById(R.id.btnChangepassword);
        btnbackChangepassword1= (Button) findViewById(R.id.btnbackChangepassword);
        Manager_Table mgrtble=new Manager_Table(this);
        Staff_Table staff_table=new Staff_Table(this);
        Customer_Table customer_table=new Customer_Table(this);

btnChangepassword1.setOnClickListener(new View.OnClickListener()
{

    @Override
    public void onClick(View v)
    {

        String userType=spuserTypeCP1.getSelectedItem().toString();
        String userName=etUsernameCP1.getText().toString();
        String oldPw=etPwOldCP1.getText().toString();
        String newPw1=etPwNewCP11.getText().toString();
        String newPw2=etPwNewCP21.getText().toString();
        if(userType.equals("Manager"))
        {
            if( newPw1.equals(newPw2))
            {

                if (mgrtble.checkUserExist(userName, oldPw))
                {


                    mgrtble.updatePassword(userName,newPw1);
                    TvRegLoginCP1.setText("Password Has been changed successfully!");


                }else
                {

                    Toast.makeText(ChangePassword.this, "Please choose correct old password ", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(ChangePassword.this, "New Password not match", Toast.LENGTH_SHORT).show();
            }



        }
        else
        if(userType.equals("Staff"))
        {
            if( newPw1.equals(newPw2))
            {

            if (staff_table.checkUserExist(userName, oldPw))
            {

                staff_table.updatePassword(userName,newPw1);
                TvRegLoginCP1.setText("Password Has been changed successfully!");

            }else
            {

                Toast.makeText(ChangePassword.this, "Please choose correct old password ", Toast.LENGTH_SHORT).show();
            }
            }
            else
            {
                Toast.makeText(ChangePassword.this, "New Password not match", Toast.LENGTH_SHORT).show();
            }

        }
        else if(userType.equals("Customer"))
        {
            if( newPw1.equals(newPw2))
            {

            if (customer_table.checkUserExist(userName, oldPw))
            {

                customer_table.updatePassword(userName,newPw1);
                TvRegLoginCP1.setText("Password Has been changed successfully!");


            }else
            {

                Toast.makeText(ChangePassword.this, "Please choose correct old password ", Toast.LENGTH_SHORT).show();
            }
            }
            else
            {
                Toast.makeText(ChangePassword.this, "New Password not match", Toast.LENGTH_SHORT).show();
            }

        }







    }
});
        btnbackChangepassword1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent page = new Intent(ChangePassword.this,MainActivity.class);
                startActivity(page);
            }
        });



    }
}