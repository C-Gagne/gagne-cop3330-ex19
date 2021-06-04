/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Crystal Gagne
 */

package org.example.ex19;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App mainApp = new App();
        double weight = mainApp.getWeight();
        double height = mainApp.getHeight();
        double reportedBMI = mainApp.calcBMI(weight, height);

        String outputString = genOutputString(reportedBMI);
        System.out.println(outputString);

    }

    public Double getWeight()
    {
        CheckInput weightCheckInput = new CheckInput();
        System.out.println("Please enter your weight, in lbs:");
        String strWeight = in.nextLine();

        boolean checkInput = weightCheckInput.isDouble(strWeight);

        while (checkInput == false) {
            System.out.println("Please make sure you have a valid numeric input.\nPlease enter your weight (in lbs):");
            strWeight = in.nextLine();

            checkInput = weightCheckInput.isDouble(strWeight);
        }

        double userWeight = Double.parseDouble(strWeight);

        if ((userWeight >= 0) && (userWeight < 2000)) {
            return userWeight;
        } else {
            System.out.println("Please enter a valid weight.");
            return getWeight();
        }
    }

    public Double getHeight()
    {
        CheckInput heightCheckInput = new CheckInput();
        System.out.println("Please enter your height, in inches:");
        String strHeight = in.nextLine();

        boolean checkInput = heightCheckInput.isDouble(strHeight);

        while (checkInput == false) {
            System.out.println("Please make sure you have a valid numeric input.\nPlease enter your height (in inches):");
            strHeight = in.nextLine();

            checkInput = heightCheckInput.isDouble(strHeight);
        }

        double userHeight = Double.parseDouble(strHeight);

        if ((userHeight >= 0) && (userHeight < 2000)) {
            return userHeight;
        } else {
            System.out.println("Please enter a valid height.");
            return getHeight();
        }
    }

    public double calcBMI(double weight, double height)
    {
        /*
        Calculate the BMI by using the following formula:
            bmi = (weight / (height × height)) * 703
        */
        double userBMI = (weight / (height*height)) * 703;

        return userBMI;
    }

    public static String genOutputString(double BMI)
    {
        if (BMI>25.0)
            return String.format("Your BMI is %.2f.\nYou are overweight. You should see your doctor.", BMI);
        if (18.5>BMI)
            return String.format("Your BMI is %.2f.\nYou are underweight. You should see your doctor.", BMI);
        if ((18.5 < BMI) && (BMI < 25.0))
            return String.format("Your BMI is %.2f.\nYou are within the ideal weight range.", BMI);
        else
            return "Error";
    }
}
