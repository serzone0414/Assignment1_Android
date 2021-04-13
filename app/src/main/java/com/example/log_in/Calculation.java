package com.example.log_in;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculation {

    public static int ageCalculator (String birthdayString) throws ParseException {
        Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthdayString);
        Date currentDate = new Date();
        long differene = currentDate.getTime() - birthday.getTime() ;
        int age = (int) (differene/1000/60/60/24/365);
        return age;
    }

    public static double bmiCalculator(double weight, double height)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        String dx=df.format(weight/((height/100)*(height/100)));
        double bmi = Double.valueOf(dx);;
        return bmi;
    }
}
