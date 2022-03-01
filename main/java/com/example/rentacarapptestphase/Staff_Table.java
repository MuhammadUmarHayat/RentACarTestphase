package com.example.rentacarapptestphase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Staff_Table extends SQLiteOpenHelper
{

    Context context;
    private static String DATABASE_NAME="StaffDb.db";
    private static int DATABASE_VERSION=2;
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOC = "location";
    private static final String KEY_DESG = "designation";
                                                                                                  //String name, String username, String passwrod, String email, String mobileNo, String address, String status
    private static String createTableQuery="create table StaffTable(name TEXT, username TEXT PRIMARY KEY,password TEXT ,email TEXT,mobileNo TEXT,address TEXT,status TEXT,Designation TEXT)";


    public Staff_Table(Context context)
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
        db.execSQL("DROP TABLE IF EXISTS StaffTable" );
        // Create tables again
        onCreate(db);
    }

// //String name, String username, String passwrod, String email, String mobileNo, String address, String status, String Designation
    public boolean Register(Staff staff)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values=new ContentValues();

        values.put("name",staff.getName());//0
        values.put("username",staff.getUserName());//1
        values.put("password",staff.getPassword());//2
        values.put("email",staff.getEmail());//3
        values.put("mobileNo",staff.getMobileNo());//4
        values.put("address",staff.getAddress());//5
        values.put("status",staff.getStatus());//6
        values.put("Designation",staff.getDesignation());//7
       // db.insert("StaffTable", null, values);

        long result = db.insert("StaffTable", null, values);//insert

        if (result == -1)
        {db.close();
        return false;

        }
        else {
            db.close();
            return true;

        }



    }

    public List<Staff> getAllStaff() {
        List<Staff> contactList = new ArrayList<Staff>();
        // Select All Query
        String selectQuery = "SELECT  * FROM StaffTable" ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                //String name, String username, String passwrod,
                // String email, String mobileNo, String address, String status, String Designation
                Staff staff=new Staff();

                staff.setName(cursor.getString(0));
                staff.setUserName(cursor.getString(1));
                staff.setPassword(cursor.getString(2));
                staff.setEmail(cursor.getString(3));
                staff.setMobileNo(cursor.getString(4));
                staff.setAddress(cursor.getString(5 ));
                staff.setStatus(cursor.getString(6));
                staff.setDesignation(cursor.getString(7));




                //   contact.set_img(cursor.getBlob(2));


                // Adding staff to list
                contactList.add(staff);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from StaffTable" , null);
        return res;
    }

    public  boolean checkUserExist(String username, String password)
    {//UserID ,Password
        String[] columns = {"username"};
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = "username=? and password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("StaffTable", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }


    public boolean updatePassword(String s, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE  ManagerTable SET password ="+"'"+password+"'" +" where username="+"'"+s+"'");
        return true;
    }

    // Get User Details

}
