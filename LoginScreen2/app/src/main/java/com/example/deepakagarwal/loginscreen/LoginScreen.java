package com.example.deepakagarwal.loginscreen;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class LoginScreen extends Activity {
    public static String[] unamearray;
    public static String[] pwdarray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        final Button loginButton = (Button)findViewById(R.id.loginBt);
        unamearray = getResources().getStringArray(R.array.Username);
        pwdarray = getResources().getStringArray(R.array.Password);

        loginButton.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick (View view)
        {
            final EditText username = (EditText)findViewById(R.id.Username);
            final EditText pwd = (EditText)findViewById(R.id.password);
            if(validateUsername(username.getText().toString())) {
                if (chkpassword(username.getText().toString(), pwd.getText().toString())) {
                    Intent welcomeIntent = new Intent();
                    welcomeIntent.setClass(LoginScreen.this, welcomeScreen.class);
                    
                    //StartActivity
                    startActivity(welcomeIntent);
                } else {
                    username.setText("");
                    pwd.setText("");
                }
            }
        }
    };
    private boolean validateUsername(String username)
    {
        boolean valid = false;
        if((username.length() > 7) && (username.length() < 13))
        {
            if(username.matches("[a-zA-Z]+"))
                valid = true;
        }

        if(!valid)
            Toast.makeText(getApplicationContext(),"Invalid Entry in Username",Toast.LENGTH_LONG).show();

        return valid;
    }

    private boolean chkpassword(String username, String password)
    {
        boolean valid = false;
        int index = Arrays.asList(unamearray).indexOf(username);

        if(index != -1)
            if(password.equals(Arrays.asList(pwdarray).get(index)))
                valid = true;

        if(!valid)
            Toast.makeText(getApplicationContext(),"Username and Password doesn't match",Toast.LENGTH_LONG).show();


        return valid;
    }

}
