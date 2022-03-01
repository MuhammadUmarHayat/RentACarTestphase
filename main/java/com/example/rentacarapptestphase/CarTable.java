package com.example.rentacarapptestphase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class CarTable extends SQLiteOpenHelper
{
    Context context;
    private static String DATABASE_NAME="CarDetailsDb123.db";
    private static int DATABASE_VERSION=2;
    private static String createTableQuery="create table CarTable(id INTEGER PRIMARY KEY AUTOINCREMENT,carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT)";

    public CarTable(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=  context;
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            db.execSQL(createTableQuery);
        }
        catch(Exception exp)
        {

            Toast.makeText(context,exp.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS CarTable" );
        // Create tables again
        onCreate(db);
    }


    //add
    public boolean addCarDetails(Car car)
    {



        //create table CarTable(id INTEGER PRIMARY KEY AUTOINCREMENT,
        // carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT)";
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values=new ContentValues();


        values.put("carId",car.getCarId());
        values.put("model",car.getModel());
        values.put("capacity",car.getCapacity());
        values.put("colour",car.getColour());
        values.put("ownerId",car.getOwnerId());
        values.put("status",car.getStatus());


        // db.insert("StaffTable", null, values);

        long result = db.insert("CarTable", null, values);//insert

        if (result == -1)
        {db.close();
            return false;

        }
        else {
            db.close();
            return true;

        }



    }

    public Cursor getAllCars()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CarTable" , null);
        return res;
    }

    public Cursor getAllRentedCars()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CarTable where status='rented'" , null);
        return res;
    }
    public Cursor getAllOutOfDutyCars()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CarTable where status='outofduty'" , null);
        return res;
    }
    public Cursor getAllAvailableCars()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CarTable where status='available'" , null);
        return res;
    }
    public Cursor getCarDetails(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CarTable where id='"+id+"'" , null);
        return res;
    }







}
