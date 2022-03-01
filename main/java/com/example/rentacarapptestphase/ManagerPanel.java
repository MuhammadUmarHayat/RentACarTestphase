package com.example.rentacarapptestphase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManagerPanel extends AppCompatActivity
{
TextView tvViewAllAvailableCars11,tvChangePwMgr1,tvViewAllUsers1,tvViewAllCars1,tvViewAllRentedCars1,tvViewAllOutofDutyCars1,tvLogout1,tvMgrAddStaff1,tvViewAllCustomers1;
    Staff_Table staff_table;
    Customer_Table customer_table;
    DbHandler cartable;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_panel);
        tvViewAllUsers1 = (TextView) findViewById(R.id.tvViewAllUsers);
        tvViewAllCars1 = (TextView) findViewById(R.id.tvViewAllCars);
        tvViewAllRentedCars1 = (TextView) findViewById(R.id.tvViewAllRentedCars);
        tvViewAllOutofDutyCars1 = (TextView) findViewById(R.id.tvViewAllOutofDutyCars);
        tvLogout1 = (TextView) findViewById(R.id.tvLogout);
        tvMgrAddStaff1 = (TextView) findViewById(R.id.tvMgrAddStaff);//tvViewAllAvailableCars1
        tvViewAllCustomers1= (TextView) findViewById(R.id.tvViewAllCustomers);
        tvViewAllAvailableCars11= (TextView) findViewById(R.id.tvViewAllAvailableCars1);//tvChangePwMgr

        tvChangePwMgr1 = (TextView) findViewById(R.id.tvChangePwMgr);
cartable=new DbHandler(this);
         staff_table=new Staff_Table(this);
         customer_table=new Customer_Table(this);


         tvChangePwMgr1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent page = new Intent(ManagerPanel.this, ChangePassword.class);
                 startActivity(page);

             }
         });

        tvViewAllCustomers1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {



                try{
                    ViewAllCustomers();
                }
                catch (Exception exp){
                    tvViewAllCustomers1.setText(exp.getMessage());

                }


            }
        });
        tvViewAllAvailableCars11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    ViewAllAvailableCars();
                }
                catch (Exception exp)
                {
                    Toast.makeText(ManagerPanel.this, "Error", Toast.LENGTH_SHORT).show();

                }
                //ViewAllAvailableCars()
            }
        });
        tvMgrAddStaff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent page = new Intent(ManagerPanel.this, StaffRegistration.class);
                startActivity(page);

            }
        });
        tvViewAllUsers1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                try{
                    ViewAllStaff();
                }
                catch (Exception exp){
                    Toast.makeText(ManagerPanel.this, "Error", Toast.LENGTH_SHORT).show();

                }


            }
        });

        tvViewAllRentedCars1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    ViewAllRentedCars();
                }
                catch (Exception exp){
                    Toast.makeText(ManagerPanel.this, "Error", Toast.LENGTH_SHORT).show();

                }
            }
        });
        ////ViewAllAvailableCars()
        tvViewAllCars1 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try{
                    ViewAllCars();

                }
                catch (Exception exp){
                    Toast.makeText(ManagerPanel.this, "Error", Toast.LENGTH_SHORT).show();

                }

            }
        });
        tvViewAllOutofDutyCars1  .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                try{
                    ViewAllOutofDutyCars();

                }
                catch (Exception exp){
                    Toast.makeText(ManagerPanel.this, "Error", Toast.LENGTH_SHORT).show();;

                }
            }
        });
        tvLogout1  .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page = new Intent(ManagerPanel.this, Logout.class);
                startActivity(page);

            }
        });



    }//on create method
    private void ViewAllStaff()
    {

        Cursor res =staff_table.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessage("Staff List","Nothing is found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext()) {
//String name, String username, String passwrod, String email, String mobileNo, String address, String status, String Designation
            buffer.append("name :" + res.getString(0) + "\n");
            buffer.append("username :" + res.getString(1) + "\n");
            buffer.append("designation " + res.getString(7) + "\n");
            buffer.append("email :" + res.getString(3) + "\n");
            buffer.append("Mobile Number " + res.getString(4) + "\n");
            buffer.append("Address:" + res.getString(5) + "\n");


        }//while
        showMessage("Staff List  ",buffer.toString());

    }

    private void ViewAllCustomers()
    {

        Cursor res =customer_table.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessage("Customer List ","Nothing is found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext()) {
//String name, String username, String passwrod, String email, String mobileNo, String address, String status, String Designation
            buffer.append("name :" + res.getString(0) + "\n");
            buffer.append("username :" + res.getString(1) + "\n");
            buffer.append("designation " + res.getString(7) + "\n");
            buffer.append("email :" + res.getString(3) + "\n");
            buffer.append("Mobile Number " + res.getString(4) + "\n");
            buffer.append("Address:" + res.getString(5) + "\n");


        }//while
        showMessage("Customer List ",buffer.toString());

    }



    private void ViewAllCars()
    {

        Cursor res =cartable.getAllCars();
        if(res.getCount() == 0) {
            // show message
            showMessage("Total Cars ","Nothing is found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext())
        {
//String name, String username, String passwrod, String email, String mobileNo, String address, String status, String Designation
            //CarTable(carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT ,imageName TEXT ,image BLOB";
            buffer.append("Id :" + res.getString(0) + "\n");
            buffer.append("carId :" + res.getString(1) + "\n");
            buffer.append("model :" + res.getString(2) + "\n");
            buffer.append("capacity " + res.getString(3) + "\n");
            buffer.append("colour :" + res.getString(4) + "\n");
            buffer.append("Owner Name " + res.getString(5) + "\n");
            buffer.append("Status:" + res.getString(6) + "\n");


        }//while
        showMessage("Total Cars  ",buffer.toString());

    }

    private void ViewAllRentedCars()
    {

        Cursor res =cartable.getAllRentedCars();
        if(res.getCount() == 0) {
            // show message
            showMessage("Total Cars ","Nothing is found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext()) {
//String name, String username, String passwrod, String email, String mobileNo, String address, String status, String Designation
            //CarTable(carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT ,imageName TEXT ,image BLOB";
            buffer.append("Id :" + res.getString(0) + "\n");
            buffer.append("carId :" + res.getString(1) + "\n");
            buffer.append("model :" + res.getString(2) + "\n");
            buffer.append("capacity " + res.getString(3) + "\n");
            buffer.append("colour :" + res.getString(4) + "\n");
            buffer.append("Owner Name " + res.getString(5) + "\n");
            buffer.append("Status:" + res.getString(6) + "\n");


        }//while
        showMessage("Total Cars  ",buffer.toString());

    }



    private void ViewAllOutofDutyCars()
    {

        Cursor res =cartable.getAllOutOfDutyCars();
        if(res.getCount() == 0) {
            // show message
            showMessage("Total Cars ","Nothing is found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext()) {
//String name, String username, String passwrod, String email, String mobileNo, String address, String status, String Designation
            //CarTable(carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT ,imageName TEXT ,image BLOB";
            buffer.append("Id :" + res.getString(0) + "\n");
            buffer.append("carId :" + res.getString(1) + "\n");
            buffer.append("model :" + res.getString(2) + "\n");
            buffer.append("capacity " + res.getString(3) + "\n");
            buffer.append("colour :" + res.getString(4) + "\n");
            buffer.append("Owner Name " + res.getString(5) + "\n");
            buffer.append("Status:" + res.getString(6) + "\n");


        }//while
        showMessage("Total Cars  ",buffer.toString());

    }

    private void ViewAllAvailableCars()
    {
//cars available for rent
        Cursor res =cartable.getAllAvailableCars();
        if(res.getCount() == 0) {
            // show message
            showMessage("Total Cars ","Nothing is found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext()) {
//String name, String username, String passwrod, String email, String mobileNo, String address, String status, String Designation
            //CarTable(carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT ,imageName TEXT ,image BLOB";
            buffer.append("Id :" + res.getString(0) + "\n");
            buffer.append("carId :" + res.getString(1) + "\n");
            buffer.append("model :" + res.getString(2) + "\n");
            buffer.append("capacity " + res.getString(3) + "\n");
            buffer.append("colour :" + res.getString(4) + "\n");
            buffer.append("Owner Name " + res.getString(5) + "\n");
            buffer.append("Status:" + res.getString(6) + "\n");

        }//while
        showMessage("Total Cars  ",buffer.toString());

    }



    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }












}