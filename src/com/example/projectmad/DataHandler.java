 package com.example.projectmad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHandler {
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String TABLE_NAME = "employeetable";
	public static final String DATA_BASE_NAME = "employeedatabase";
	public static final int DATABASE_VERSION = 1;
	public static final String TABLE_CREATE = "create table employeetable (name text not null, email text not null , password text not null);";
	DataBaseHelper dbhelper;
	Context ctx;
	SQLiteDatabase db;
	public DataHandler(Context ctx){
		this.ctx = ctx;
		dbhelper = new DataBaseHelper(ctx);
	}
	private static class DataBaseHelper extends SQLiteOpenHelper{

		public DataBaseHelper(Context ctx) {
			super(ctx, DATA_BASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try{
			db.execSQL(TABLE_CREATE);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("Drop Table if exists mytable");
			onCreate(db);
		}
		
	}
	public DataHandler open(){
		db = dbhelper.getWritableDatabase();
		return this;
	}
	public void close(){
		dbhelper.close();
	}
	public long insertData(String name, String email, String password){
		ContentValues content =  new ContentValues();
		content.put(NAME, name);
		content.put(EMAIL, email);
		content.put(PASSWORD, password);
		return db.insertOrThrow(TABLE_NAME, null, content);
	}
	public  String getUserLogin(String email){
		//return db.query( TABLE_NAME, new String[] {NAME,EMAIL,PASSWORD}, null, null, null, null, null, null);
		Cursor cursor=db.query(TABLE_NAME, null, "EMAIL=?",new String[]{email}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
        	cursor.close();
        	return "NOT EXIST";
        }
	    cursor.moveToFirst();
		String getPass= cursor.getString(cursor.getColumnIndex("password"));
		cursor.close();
		//String password = "shweta123";
		return getPass;	
	}
}
