package com.capstone.jhea.classmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity implements OnClickListener {

    Button btnLogIn,btnSignUp;
    TCMDataBaseAdapter TCMDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // create a instance of SQLite Database
        TCMDataBaseAdapter=new TCMDataBaseAdapter(this);
        TCMDataBaseAdapter=TCMDataBaseAdapter.open();

        // Get The Reference Of Buttons
        btnLogIn=(Button)findViewById(R.id.btnLogin);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        btnLogIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        // get the Refferences of views
        final  EditText etUsername=(EditText) findViewById(R.id.etUsername);
        final  EditText etPassword=(EditText) findViewById(R.id.etPassword);

        switch (v.getId()) {
            case R.id.btnLogin:

                String userName=etUsername.getText().toString();
                String password=etPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword=TCMDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(LoginActivity.this, "Login Successful.", Toast.LENGTH_LONG).show();
                    Intent intentLogin=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intentLogin);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btnSignUp:
                Intent intentSignUP=new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intentSignUP);
                break;

            default:
                break;
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        TCMDataBaseAdapter.close();
    }

}
