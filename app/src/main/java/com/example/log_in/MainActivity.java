package com.example.log_in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.Executor;


public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText Name, Password;
    TextView registerLink;
    Toolbar toolbar;
    Account demo = new Account("Admin","1234");
    DbHandler dbHandler = new DbHandler(MainActivity.this);


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
        //newAccount = (Account) intent.getSerializableExtra("newAcount");
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
                //printAllAccounts();
            }
        });
    }

    private void accessRegister() {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }

    private void accessActivity2(String userName, String userPassword) {
        DbHandler dbHandler = new DbHandler(MainActivity.this);
        dbHandler.addOne(demo);
        List<Account> accountList = dbHandler.getAllAccounts();
        boolean correctAccount = false;

        for (int i = 0; i < accountList.size(); i++) {
            if (userName.equals(accountList.get(i).getUsername()) && (userPassword.equals(accountList.get(i).getPassword()))) {
                createDemoResidents();
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                correctAccount = true;
            }
        }
        if (correctAccount == false) {
            Toast.makeText(MainActivity.this, "Wrong username / password", Toast.LENGTH_SHORT).show();
        } else{Toast.makeText(MainActivity.this, "Welcome" , Toast.LENGTH_SHORT).show();}
    }



        private void createDemoResidents()
        {
            Resident demo = new Resident("Bob", "Smith (Demo - Low Age)", "01/01/1970", 80, 175, "Male");
            try {
                demo.setAge(Calculation.ageCalculator(demo.getDateOfBirth()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            demo.setBmi(Calculation.bmiCalculator(demo.getWeight(),demo.getHeight()));

            Resident demoTwo = new Resident("Merry", "Kerr (Demo - High BMI)", "01/01/1950", 140, 169, "Female");
            try {
                demoTwo.setAge(Calculation.ageCalculator(demoTwo.getDateOfBirth()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            demoTwo.setBmi(Calculation.bmiCalculator(demoTwo.getWeight(),demoTwo.getHeight()));

            Resident demoThree = new Resident("Tony", "Lee (Demo - Acceptable resident)", "01/01/1950", 75, 172, "Male");
            try {
                demoThree.setAge(Calculation.ageCalculator(demoThree.getDateOfBirth()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            demoThree.setBmi(Calculation.bmiCalculator(demoThree.getWeight(),demoThree.getHeight()));
            dbHandler.addOne(demoThree);
            dbHandler.addOne(demoTwo);
            dbHandler.addOne(demo);

        }
    }

