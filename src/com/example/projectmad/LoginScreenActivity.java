package com.example.projectmad;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginScreenActivity extends Activity {
	Button login,register;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        
        OnClickListener handler = null;
		login.setOnClickListener(new View.OnClickListener() {
			 
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), LoginMainActivity.class);
 
                //Sending data to another Activity
                
                startActivity(nextScreen);
 
            }
        });
		register.setOnClickListener(new View.OnClickListener() {
			 
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), RegisterMainActivity.class);
 
                //Sending data to another Activity
                
                startActivity(nextScreen);
 
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
