/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Crystal Gagne
 */

package org.example.ex19;

public class CheckInput {
    public boolean isDouble(String inputString)
    {

        if (inputString == null)
            return false;

        int strLength = inputString.length();

        if (strLength == 0)
            return false;

        int i = 0;
        int decimalCount = 0;

        if (inputString.charAt(i) == '-' && i == 0)
        {
            i = 1;
        }

        for (; i < strLength; i++)
        {
            if ((inputString.charAt(i) == '.') && (decimalCount < 1))
            {
                decimalCount++;
            }
            else if (inputString.charAt(i) < '0' || inputString.charAt(i) > '9')
            {
                return false;
            }
        }
        return true;
    }
}
