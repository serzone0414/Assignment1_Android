package com.example.log_in;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText newUserName, newPassWord;
    Button returnButton;
    Account newAcount = new Account();
    DbHandler dbHandler = new DbHandler(Register.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        newUserName = (EditText)findViewById(R.id.newUserName);
        newPassWord = (EditText)findViewById(R.id.newPassWord);
        returnButton = (Button) findViewById(R.id.ReturnButton);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register new account");

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(newUserName.getText().toString()))
                {
                    Toast.makeText(Register.this,"Username is empty.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(newPassWord.getText().toString()))
                {
                    Toast.makeText(Register.this,"Password is empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    accessActivity2(newAcount);
                }
            }
        });

    }

    private void accessActivity2(Account newAcount) {
        newAcount.setUsername(newUserName.getText().toString());
        newAcount.setPassword(newPassWord.getText().toString());

        //database building

        try {

            boolean success = dbHandler.addOne(newAcount);
            Toast.makeText(Register.this, "New acount created", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(Register.this, "Error creating customer", Toast.LENGTH_SHORT).show();
            Account failedAccount = new Account("Error","Error");
            dbHandler.addOne(failedAccount);

        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}