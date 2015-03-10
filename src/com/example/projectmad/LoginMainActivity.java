package com.example.projectmad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginMainActivity extends Activity{
	EditText email,password;
	Button login;
	DataHandler handler;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
     // create a instance of SQLite Database
	     handler=new DataHandler(this);
	     handler=handler.open();

     // Set On ClickListener
        login.setOnClickListener(new View.OnClickListener() {
      
     				public void onClick(View v) {
     					// get The User name and Password
     					String getEmail=email.getText().toString();
     					String getPassword=password.getText().toString();
     					
     	        		System.out.println("Outside userlogin");
     					// fetch the Password form database for respective user name
     					String storedPassword=handler.getUserLogin(getEmail);
      
     					// check if the Stored password matches with  Password entered by user
     					if(getPassword.equals(storedPassword))
     					{
     						
     						//Toast.makeText(LoginMainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
     						Intent intent = new Intent(LoginMainActivity.this, UserActivity.class);
     						//intent.putExtra("getEmail","value");
     						//startActivity(intent);
     					}
     					else
     					{
     						Toast.makeText(LoginMainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
     					}
     				}
     			});
      
       	}
      
     	@Override
     	protected void onDestroy() {
     		super.onDestroy();
     	    // Close The Database
     		handler.close();
     	}
        
        
	
	
}
