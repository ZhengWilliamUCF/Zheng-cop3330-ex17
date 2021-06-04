/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 William Zheng
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        String userGender = myApp.readUserGender();
        double Weight = myApp.readUserWeight();
        double ADR = myApp.GenderCheck(userGender);
        double Consumption = myApp.readUserConsumption();
        double Hours = myApp.readUserTime();
        String displayMessage = myApp.BACCheck(Consumption, Weight, ADR, Hours);
        String outputString = myApp.generateOutputString(displayMessage);
        myApp.printOutput(outputString);
    }

    public void printOutput(String outputString) {
        System.out.println(outputString);
    }

    public double readUserWeight(){
        System.out.print("What is your weight in pounds? ");
        return in.nextDouble();
    }

    public String readUserGender(){
        System.out.print("What is your gender? (Please enter M or F) ");
        return in.nextLine();
    }

    public double readUserConsumption(){
        System.out.print("How many ounces of alcohol did you consume? ");
        return in.nextDouble();
    }

    public double readUserTime(){
        System.out.print("How long has it been since your last drink? ");
        return in.nextDouble();
    }

    public String BACCheck(Double Consumption, Double Weight, Double ADR, Double Hours){
        double BAC = ((Consumption * 5.14)/(Weight * ADR)) - (0.015 * Hours);
        return (BAC > 0.08) ? String.format("Your BAC is %s.\nIt is not legal for you to drive.", BAC) : String.format("Your BAC is %s.\nIt is legal for you to drive.", BAC);
    }
    public double GenderCheck(String userGender){
        if (userGender.equals("M")){
            return 0.73;
        }
        else if (userGender.equals("F")){
            return 0.66;
        }
        else {
            System.out.print("Please enter M or F");
            return GenderCheck(userGender);
        }
    }

    public String generateOutputString(String displayMessage){
        return displayMessage;
    }
}