package com.example.rentacarapptestphase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.Nullable;
import android.provider.MediaStore;

public class AddCarDetails extends AppCompatActivity
{
    private static final int PICK_IMAGE_REQUEST=100;
    private EditText editTextcarId1,editTextModel1,editTextCapacity1,editTextColour1,editTextOwnerId1;
    private ImageView objectImageView;
    Button btnSave,btnback;

    CarTable carTable;
    Spinner spStatus;
    Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_details);
try {
    carTable = new CarTable(this);
    car = new Car();

    editTextcarId1 = (EditText) findViewById(R.id.editTextcarId);
    editTextModel1 = (EditText) findViewById(R.id.editTextModel);
    editTextCapacity1 = (EditText) findViewById(R.id.editTextCapacity);
    editTextColour1 = (EditText) findViewById(R.id.editTextColour);
    editTextOwnerId1 = (EditText) findViewById(R.id.editTextOwnerId);


    spStatus = (Spinner) findViewById(R.id.spStatus);
    //  objectImageView = (ImageView) findViewById(R.id.Image1);

    btnSave = (Button) findViewById(R.id.btnAddCarDetails1);
    btnback = (Button) findViewById(R.id.btnbackStaff);

}
catch (Exception exp)
{

    editTextOwnerId1.setText(exp.getMessage().toString());
}


     btnback.setOnClickListener(new View.OnClickListener()
     {
         @Override
         public void onClick(View v)
         {

             Intent page = new Intent(AddCarDetails.this, StaffPanel.class);
             startActivity(page);
         }
     });

        btnSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                String carID=editTextcarId1.getText().toString();
                String model=editTextModel1.getText().toString();
                String capacity=editTextCapacity1.getText().toString();
                String colour=editTextColour1.getText().toString();
                String status=spStatus.getSelectedItem().toString();
                String Ownerid=editTextOwnerId1.getText().toString();

car.setCarId(carID);
car.setModel(model);
car.setCapacity(capacity);
car.setColour(colour);
car.setStatus(status);
                DbHandler dbHandler = new DbHandler(AddCarDetails.this);
                //dbHandler.insertUserDetails(carID,model,capacity,colour,Ownerid,status)
if (dbHandler.insertUserDetails(carID,model,capacity,colour,Ownerid,status))
{
    Toast.makeText(AddCarDetails.this, "Car is added successfully! ", Toast.LENGTH_SHORT).show();
}
else{

    Toast.makeText(AddCarDetails.this, "Car is not added successfully! ", Toast.LENGTH_SHORT).show();

}




            }
        });

    }//oncreate






}//end of add Car Details
