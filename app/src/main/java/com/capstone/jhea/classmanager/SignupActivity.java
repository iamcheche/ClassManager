package com.capstone.jhea.classmanager;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends Activity {

    EditText etName, etEmail, etUsername, etPassword, etConfirmPassword;
    Button btnSignUp;
    TCMDataBaseAdapter TCMDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // get Instance  of Database Adapter
        TCMDataBaseAdapter=new TCMDataBaseAdapter(this);
        TCMDataBaseAdapter=TCMDataBaseAdapter.open();

        // Get Refferences of Views
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword=(EditText)findViewById(R.id.etConfirmPassword);


        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String name=etName.getText().toString();
                String email=etEmail.getText().toString();
                String username=etUsername.getText().toString();
                String password=etPassword.getText().toString();
                String confirmPassword=etConfirmPassword.getText().toString();


                // check if any of the fields are vacant
                if (name.equals("")||email.equals("")||username.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vacant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    TCMDataBaseAdapter.insertEntry(name, email, username, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        TCMDataBaseAdapter.close();
    }


}