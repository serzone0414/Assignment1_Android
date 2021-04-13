package com.example.log_in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.concurrent.Executor;


public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText Name, Password;
    TextView registerLink;
    Toolbar toolbar;
    Account demo = new Account("Admin","1234");
    Account newAccount = new Account();

    @Override
    public boolean bindIsolatedService(Intent service, int flags, String instanceName, Executor executor, ServiceConnection conn) {
        return super.bindIsolatedService(service, flags, instanceName, executor, conn);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                Intent help = new Intent(this,help.class);
                startActivity(help);
                Toast.makeText(getApplicationContext(),"Help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Intent settings = new Intent(this,SettingsActivity.class);
                startActivity(settings);
                Toast.makeText(getApplicationContext(),"Settings", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        newAccount = (Account) intent.getSerializableExtra("newAcount");
        registerLink = (TextView) findViewById(R.id.registerButton);
        loginButton = (Button) findViewById(R.id.button);
        Name = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessRegister();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessActivity2(Name.getText().toString(),Password.getText().toString());

            }
        });
    }

    private void accessRegister() {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }

    private void accessActivity2(String userName, String userPassword) {

            if ((userName.equals(demo.getUsername()))&& (userName.equals(demo.getUsername())))
            {
                Intent intent = new Intent(this, Activity2.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(MainActivity.this,"Wrong username / password", Toast.LENGTH_SHORT).show();
            }
        }



    }

