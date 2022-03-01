package com.example.rentacarapptestphase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Customer_Table extends SQLiteOpenHelper
{
    Context context;
    private static String DATABASE_NAME="CuatomerDb.db";
    private static int DATABASE_VERSION=3;
    //String name, String username, String passwrod, String email, String mobileNo, String address, String status
    private static String createTableQuery="create table CustomerTable(name TEXT, username TEXT PRIMARY KEY,password TEXT ,email TEXT,mobileNo TEXT,address TEXT,status TEXT)";


    public Customer_Table(Context context)
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
        db.execSQL("DROP TABLE IF EXISTS CustomerTable" );
        // Create tables again
        onCreate(db);
    }

    // //String name, String username, String passwrod, String email, String mobileNo, String address, String status, String Designation
    public boolean Register(Customer staff)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values=new ContentValues();

        values.put("name",staff.getName());
        values.put("username",staff.getUserName());
        values.put("password",staff.getPassword());
        values.put("email",staff.getEmail());
        values.put("mobileNo",staff.getMobileNo());
        values.put("address",staff.getAddress());
        values.put("status",staff.getStatus());//

        // db.insert("StaffTable", null, values);

        long result = db.insert("CustomerTable", null, values);//insert

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
        String selectQuery = "SELECT  * FROM CustomerTable" ;

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

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CustomerTable" , null);
        return res;
    }

    public boolean checkUserExist(String username, String password)
    {//UserID ,Password
        String[] columns = {"username"};
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = "username=? and password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("CustomerTable", columns, selection, selectionArgs, null, null, null);
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


}
