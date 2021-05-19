package com.example.log_in;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class Activity9 extends AppCompatActivity {
    EditText et_note;
    Button createPdfButton;
    Resident resident;
    String[] informationArray = new String[] {"Name", "Age","BMI","Contact"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);

        Intent intent = getIntent();
        Resident resident = (Resident) intent.getSerializableExtra("resident");

        createPdfButton = (Button) findViewById(R.id.createPdfButton);
        et_note=(EditText) findViewById(R.id.et_note);

        ActivityCompat.requestPermissions(Activity9.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        createPdfButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                createPDF(resident);
            }

        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createPDF(Resident resident) {
        PdfDocument myPdfDocument = new PdfDocument();
        Paint myPaint = new Paint();

        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(250,400,1).create();
        PdfDocument.Page myPage1 = myPdfDocument.startPage(myPageInfo);
        Canvas canvas = myPage1.getCanvas();

        myPaint.setTextAlign(Paint.Align.CENTER);
        myPaint.setTextSize(12.0f);
        canvas.drawText("ARVIDA Aria Park",myPageInfo.getPageWidth()/2,30,myPaint);

        myPaint.setTextSize(6.0f);
        myPaint.setColor(Color.rgb(122,119,119));
        canvas.drawText("Address:1-3 Clausde Road, Epsom, Auckland 1023", myPageInfo.getPageWidth()/2,40,myPaint);


        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.BLACK);
        canvas.drawText("Resident Information", 10,70,myPaint);

        int startXPosition = 10;
        int endXPosition = myPageInfo.getPageWidth()-10;
        int startYPosition = 100;

        for (int i = 0 ; i < 4; i++)
        {
            canvas.drawText(informationArray[i],startXPosition,startYPosition,myPaint);
            canvas.drawLine(startXPosition,startYPosition+3, endXPosition,startYPosition+3, myPaint);
            startYPosition +=20;
        }
        canvas.drawLine(80,92,80,172,myPaint);

        canvas.drawText("Note", 10, 190,myPaint);
        canvas.drawLine(10, 215, myPageInfo.getPageWidth()-10, 215,myPaint);
        canvas.drawLine(10, 235, myPageInfo.getPageWidth()-10, 235,myPaint);
        canvas.drawLine(10, 255, myPageInfo.getPageWidth()-10, 255,myPaint);
        canvas.drawLine(10, 275, myPageInfo.getPageWidth()-10, 275,myPaint);
        canvas.drawLine(10, 295, myPageInfo.getPageWidth()-10, 295,myPaint);
        canvas.drawLine(10, 315, myPageInfo.getPageWidth()-10, 315,myPaint);
        canvas.drawLine(10, 335, myPageInfo.getPageWidth()-10, 335,myPaint);
        canvas.drawLine(10, 355, myPageInfo.getPageWidth()-10, 355,myPaint);


        // Information entering
        myPaint.setColor(Color.BLUE);
        myPaint.setColor(Color.rgb(122,119,119));
        myPage1.getCanvas().drawText(resident.getFirstName() + " " + resident.getLastName(), 85, 100, myPaint);
        myPage1.getCanvas().drawText(String.valueOf(resident.getAge()), 85, 120, myPaint);
        myPage1.getCanvas().drawText(String.valueOf(resident.getBmi()), 85, 140, myPaint);
        myPage1.getCanvas().drawText(resident.getEPOAfamilyContact(), 85, 160, myPaint);

        String myString = et_note.getText().toString();
        startXPosition = 10;
        startYPosition = 213;
        myPaint.setTextSize(6.0f);

        for (String line: myString.split("\n")){
            myPage1.getCanvas().drawText(line,startXPosition,startYPosition,myPaint);
            startYPosition += 20;
        }


        myPdfDocument.finishPage(myPage1);


        //String myFilePath = Environment.getExternalStorageDirectory().getPath() + "/myPDFFile.pdf";

        File myFile = new File (getExternalFilesDir(null),resident.getFirstName()+" 's Info.pdf");

        try {
            myPdfDocument.writeTo(new FileOutputStream(myFile));
            Toast.makeText(Activity9.this, "PDF file created", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(Activity9.this, "ERROR" , Toast.LENGTH_LONG).show();
        }
        myPdfDocument.close();


    }




}