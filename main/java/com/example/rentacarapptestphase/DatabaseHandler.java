package com.example.rentacarapptestphase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static android.icu.text.DisplayContext.LENGTH_SHORT;


public class DatabaseHandler extends SQLiteOpenHelper
{
    Context context;
    private static String DATABASE_NAME="CarsDb.db";
    private static int DATABASE_VERSION=1;
    //String s="create table CarTable(carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT ,imageName TEXT ,image BLOB";
    private static String createTableQuery="create table CarTable(id INTEGER PRIMARY KEY AUTOINCREMENT,carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT ,imageName TEXT ,image BLOB)";
    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInBytes;


    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=  context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        try
        {
            sqLiteDatabase.execSQL(createTableQuery);
        }
        catch(Exception exp)
        {

            Toast.makeText(context,exp.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

    public void storeImage(Car car)
    {
        try
        {
            SQLiteDatabase objectSqLiteDatabase=this.getWritableDatabase();
            Bitmap imageToStoreBitmap=car.getImage();
            objectByteArrayOutputStream =new ByteArrayOutputStream();
            imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG,100,objectByteArrayOutputStream);
            imageInBytes=objectByteArrayOutputStream.toByteArray();
            ContentValues objectValues=new ContentValues();//imageInfo(imageName TEXT ,image BLOB)
           //CarTable(carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT ,imageName TEXT ,image BLOB";
            objectValues.put("carId",car.getCarId());
            objectValues.put("model",car.getModel());
            objectValues.put("capacity",car.getCapacity());
            objectValues.put("colour",car.getColour());
            objectValues.put("ownerId",car.getOwnerId());
            objectValues.put("status",car.getStatus());
            objectValues.put("imageName",car.getImageName());
            objectValues.put("image",imageInBytes);
            long result=objectSqLiteDatabase.insert("CarTable",null,objectValues);
            if(result!=-1)
            {
                Toast.makeText(context,"Data is saved",Toast.LENGTH_SHORT).show();
                objectSqLiteDatabase.close();
            }
            else{
                Toast.makeText(context,"Data is not saved",Toast.LENGTH_SHORT).show();

            }


        }
        catch(Exception exp)
        {

            Toast.makeText(context,exp.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }//store image


    public ArrayList<Car> getAllImagesData()
    {
        try
        {

            //"";// String imageName, Bitmap image;
            SQLiteDatabase objectSqliteDatabase=this.getReadableDatabase();
            ArrayList<Car> objectModelClassList=new ArrayList<>();
            Cursor objectCursor=objectSqliteDatabase.rawQuery("select * from imageInfo ",null);
            if(objectCursor.getCount()!=0)
            {
                while(objectCursor.moveToNext())
                {
                    int id=objectCursor.getInt(0);
                    String carId=objectCursor.getString(1);
                    String model=objectCursor.getString(2);
                    String capacity=objectCursor.getString(3);
                    String colour =objectCursor.getString(4);
                    String ownerId=objectCursor.getString(5);
                    String status=objectCursor.getString(6);
                    String nameOfImage=objectCursor.getString(7);
                    byte[] imageByte=objectCursor.getBlob(8);
                    Bitmap objectBitmap= BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);
                    objectModelClassList.add(new Car(id,carId,model,capacity,colour,ownerId,status,nameOfImage,objectBitmap));

                }
                return objectModelClassList;
            }
            else{
                Toast.makeText(context,"value does not exist in database ",Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        catch(Exception exp)
        {
            Toast.makeText(context,exp.getMessage(),Toast.LENGTH_SHORT).show();


            return null;
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
