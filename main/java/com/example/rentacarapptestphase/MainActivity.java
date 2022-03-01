package com.example.rentacarapptestphase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText etusername,etpw;
    Spinner spinner;
    TextView tvReg;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etusername = (EditText) findViewById(R.id.etUsernamelogn);
        etpw = (EditText) findViewById(R.id.etPwLogin);

        tvReg = (TextView) findViewById(R.id.TvRegLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin1);
        spinner=(Spinner)findViewById(R.id.spuserType) ;

        Customer_Table customer_table=new Customer_Table(this);
        Staff_Table staff_table=new Staff_Table(this);

        Manager_Table manager_table=new Manager_Table(this);





        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(MainActivity.this, "User type: "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });



        tvReg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //CustomerRegistration
              // String  usertype=spinner.getSelectedItem().toString();
                Intent page = new Intent(MainActivity.this, CustomerRegistration.class);
                startActivity(page);



            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String  usertype=spinner.getSelectedItem().toString();

                String userid = etusername.getText().toString();
                String password = etpw.getText().toString();
if(usertype.equals("Manager"))
{
    if (manager_table.checkUserExist(userid, password))
    {

        Intent intent = new Intent(getBaseContext(), ManagerPanel.class);

        startActivity(intent);


    }else
    {

        Toast.makeText(MainActivity.this, "Please choose correct userid or password ", Toast.LENGTH_SHORT).show();
    }




}
               else if(usertype.equals("Staff"))
               {
                   if (staff_table.checkUserExist(userid, password))
                   {

                       Intent intent = new Intent(getBaseContext(), StaffPanel.class);

                       startActivity(intent);


                   }
                   else
                   {

                       Toast.makeText(MainActivity.this, "Please choose correct userid or password ", Toast.LENGTH_SHORT).show();
                   }


               }
              else   if(usertype.equals("Customer"))
              {
                  if (customer_table.checkUserExist(userid, password))
                  {

                      Intent intent = new Intent(getBaseContext(), ViewCars1.class);

                      startActivity(intent);


                  }
                  else
                  {

                      Toast.makeText(MainActivity.this, "Please choose correct userid or password ", Toast.LENGTH_SHORT).show();
                  }


                }

              else
{

    Toast.makeText(MainActivity.this, "Please choose user type ", Toast.LENGTH_SHORT).show();
}




            }
        });






    }
}