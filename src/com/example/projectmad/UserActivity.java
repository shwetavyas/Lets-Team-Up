package com.example.projectmad;

import com.databasedemo.DataHandler;
import com.databasedemo.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button) findViewById(R.id.savedata);
        load = (Button) findViewById(R.id.loaddata);
        email = (EditText) findViewById(R.id.email);
        name=(EditText) findViewById(R.id.name);
         save.setOnClickListener(new OnClickListener(){
        	 
        	 @Override
        	 public void onClick(View v){
        		 String getName = name.getText().toString();
        		 String getEmail = name.getText().toString();
        		 handler = new DataHandler(getBaseContext());
        		 handler.open();
        		 long id = handler.insertData(getName, getEmail);
        		 Toast.makeText(getBaseContext(), "Data inserted", Toast.LENGTH_SHORT).show();
        		 handler.close();
        	 }
         });
         
load.setOnClickListener(new OnClickListener(){
        	 
        	 @Override
        	 public void onClick(View v){
        		 String getName,getEmail;
        		 getName = "";
        		 getEmail = "";
        		 handler = new DataHandler(getBaseContext());
        		 handler.open();
        		 Cursor C = handler.returnData();
        		 if (C.moveToFirst()){
        			 do{
        				 getName = C.getString(0);
        				 getEmail = C.getString(1);
                		 Toast.makeText(getBaseContext(), "Name:" +getName+" And Email:"+getEmail, Toast.LENGTH_LONG).show();

        			 }while(C.moveToNext());
        			 
        		 }
        		 
        		 handler.close();
        	 }
         });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_screen, menu);
        return true;
    }
    
}
