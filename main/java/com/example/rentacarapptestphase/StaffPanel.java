package com.example.rentacarapptestphase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StaffPanel extends AppCompatActivity
{
TextView tvstaffAddCarDetails1,tvstaffViewCarDetails1,tvstaffLogout1;
    DbHandler carTable;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_panel);

        tvstaffAddCarDetails1 = (TextView) findViewById(R.id.tvstaffAddCarDetails);
        tvstaffViewCarDetails1 = (TextView) findViewById(R.id.tvstaffViewCarDetails);
        tvstaffLogout1 = (TextView) findViewById(R.id.tvstaffLogout);
        carTable=new DbHandler(this);

        tvstaffAddCarDetails1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {

                    Intent page = new Intent(StaffPanel.this, AddCarDetails.class);
                    startActivity(page);
                }
                catch (Exception exp){


                    tvstaffLogout1.setText(exp.getMessage().toString());
                }

            }
        });


        tvstaffViewCarDetails1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               // Intent page = new Intent(StaffPanel.this, DetailsActivity.class);
              //  startActivity(page);



try {
    ViewAllAvailableCars();
}
catch (Exception exp)
{


    Toast.makeText(StaffPanel.this, exp.getMessage().toString(), Toast.LENGTH_SHORT).show();
}


            }
        });
        tvstaffLogout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent page = new Intent(StaffPanel.this, Logout.class);
                startActivity(page);

            }
        });





    }//oncreate


    private void ViewAllAvailableCars()
    {
//cars available for rent
        Cursor res =carTable.getAllCars();
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
            buffer.append("carId :" + res.getString(0) + "\n");
            buffer.append("model :" + res.getString(1) + "\n");
            buffer.append("capacity " + res.getString(2) + "\n");
            buffer.append("colour :" + res.getString(3) + "\n");
            buffer.append("Owner Name " + res.getString(4) + "\n");
            buffer.append("Status:" + res.getString(5) + "\n");


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