package com.example.rentacarapptestphase;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class DbHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "MyNewCarDB";
    private static final String TABLE_Users = "carTable";
    //carId TEXT, model TEXT, capacity TEXT, colour TEXT, ownerId TEXT,status TEXT
    private static final String KEY_ID = "id";//0

    private static final String KEY_CARID = "carId";//1
    private static final String KEY_MODEL = "model";//2
    private static final String KEY_CAPACITY = "capacity";//3
    private static final String KEY_COLOUR = "colour";//4
    private static final String KEY_OWNERID = "ownerId";//5
    private static final String KEY_STATUS = "status";//6






    public DbHandler(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_CARID + " TEXT,"
                + KEY_MODEL + " TEXT,"
                + KEY_CAPACITY + " TEXT,"
                + KEY_COLOUR + " TEXT,"
                + KEY_OWNERID + " TEXT,"
                + KEY_STATUS + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        // Create tables again
        onCreate(db);
    }
    // **** CRUD (Create, Read, Update, Delete) Operations ***** //

    // Adding new User Details
    public boolean insertUserDetails(String carId ,String model,String capacity,String colour,String ownerId,String status)
    {
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_CARID,carId);//1
        cValues.put(KEY_MODEL,model);
        cValues.put(KEY_CAPACITY,capacity);
        cValues.put(KEY_COLOUR,colour);
        cValues.put(KEY_OWNERID,ownerId);
        cValues.put(KEY_STATUS,status);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Users,null, cValues);
        db.close();
        if(newRowId==-1)
        {

            return false;
        }
        else return true;

    }
    // Get User Details
    @SuppressLint("Range")
    public ArrayList<HashMap<String, String>> GetUsers()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT id,carid,model,ownerid FROM "+ TABLE_Users;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("id",cursor.getString(cursor.getColumnIndex(KEY_ID)));
            user.put("carid",cursor.getString(cursor.getColumnIndex(KEY_CARID)));
            user.put("model",cursor.getString(cursor.getColumnIndex(KEY_MODEL)));
            user.put("ownerId",cursor.getString(cursor.getColumnIndex(KEY_OWNERID)));

            user.put("capacity",cursor.getString(cursor.getColumnIndex(KEY_CAPACITY)));
            user.put("colour",cursor.getString(cursor.getColumnIndex(KEY_COLOUR)));
            user.put("status",cursor.getString(cursor.getColumnIndex(KEY_STATUS)));





            userList.add(user);
        }
        return  userList;
    }
    // Get User Details based on userid
    @SuppressLint("Range")
    public ArrayList<HashMap<String, String>> GetUserByUserId(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT id,carid,model,ownerid FROM "+ TABLE_Users;
        Cursor cursor = db.query(TABLE_Users, new String[]{KEY_CARID, KEY_MODEL, KEY_OWNERID}, KEY_ID+ "=?",new String[]{String.valueOf(userid)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("id",cursor.getString(cursor.getColumnIndex(KEY_ID)));
            user.put("carid",cursor.getString(cursor.getColumnIndex(KEY_CARID)));
            user.put("model",cursor.getString(cursor.getColumnIndex(KEY_MODEL)));
            user.put("ownerId",cursor.getString(cursor.getColumnIndex(KEY_OWNERID)));

            user.put("capacity",cursor.getString(cursor.getColumnIndex(KEY_CAPACITY)));
            user.put("colour",cursor.getString(cursor.getColumnIndex(KEY_COLOUR)));
            user.put("status",cursor.getString(cursor.getColumnIndex(KEY_STATUS)));
            userList.add(user);
        }
        return  userList;
    }
    // Delete User Details
    public void DeleteUser(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users, KEY_ID+" = ?",new String[]{String.valueOf(userid)});
        db.close();
    }
    // Update User Details
    public int UpdateUserDetails(String location, String designation, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_CARID ,location);
        cVals.put(KEY_MODEL, designation);
        int count = db.update(TABLE_Users, cVals, KEY_ID+" = ?",new String[]{String.valueOf(id)});
        return  count;
    }
    public Cursor getAllCars()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from CarTable" , null);
        return res;
    }
    public Cursor getCar(String cid)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from CarTable where carId='"+cid+"'" , null);
        return res;
    }
    public Cursor getAllAvailableCars()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CarTable where status='Available'" , null);
        return res;
    }

    public Cursor getAllRentedCars()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CarTable where status='Rented'" , null);
        return res;
    }
    public Cursor getAllOutOfDutyCars()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CarTable where status='OutOfDuty'" , null);
        return res;
    }



}
