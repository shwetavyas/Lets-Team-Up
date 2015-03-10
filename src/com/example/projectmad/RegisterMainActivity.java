package com.example.projectmad;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterMainActivity extends Activity{
	Button save;
	EditText name,email,password;
	DataHandler handler;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);
        save = (Button) findViewById(R.id.save);
        
        name=(EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        save.setOnClickListener(new OnClickListener(){
        	 
        	 @Override
        	 public void onClick(View v){
        		 String getName = name.getText().toString();
        		 String getEmail = email.getText().toString();
        		 String getPassword = password.getText().toString();
        		 handler = new DataHandler(getBaseContext());
        		 handler.open();
        		 long id = handler.insertData(getName, getEmail, getPassword);
        		 Toast.makeText(getBaseContext(), "You are registered", Toast.LENGTH_SHORT).show();
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
