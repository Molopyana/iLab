package com.ilabquality.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberGenerator {
    public static String generateNumber()
    {
        int num1, num2, num3;
        int set2, set3;

        Random generator = new Random();

        num1 = 0;
        num2 = generator.nextInt(2)+6;
        num3 = generator.nextInt(7) + 1;
        String areaCode = String.valueOf(num1)+String.valueOf(num2)+String.valueOf(num3);

        set2 = generator.nextInt(899) + 100;
        set3 = generator.nextInt(8999) + 1000;

        return  areaCode  +" "+ set2 +" "+ set3;

    }

    public static String getValidPhoneNumber(){
        String generatedNumber = generateNumber();

        while(!(isValidateNumber(generatedNumber))){

            generatedNumber = generateNumber();
        }

        return generatedNumber;

    }

    private static boolean isValidateNumber(String number){
        boolean valid = false;
        Pattern pattern = Pattern.compile("\\d{3}\\x20\\d{3}\\x20\\d{4}");
        Matcher matcher = pattern.matcher(number);

        if (matcher.matches()) {
            valid = true;
        }

        return valid;
    }
}
