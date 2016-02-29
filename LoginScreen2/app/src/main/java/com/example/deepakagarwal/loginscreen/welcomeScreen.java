package com.example.deepakagarwal.loginscreen;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class welcomeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        TextView text1 = (TextView)findViewById(R.id.HelloText);    
        text1.setText("I am good to go Android");
        Button bt = (Button)findViewById(R.id.logoutBt);
        bt.setOnClickListener(onclickListner);

    }

    View.OnClickListener onclickListner =  new View.OnClickListener(){
            public void onClick(View view)
            {
                finish();
            }
   };
}
