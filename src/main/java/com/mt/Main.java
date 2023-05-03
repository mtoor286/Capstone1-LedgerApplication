package com.mt;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
//    static ArrayList<Transactions> transactions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {

        String input = new String();
        do {
            System.out.println("--Home--");
            System.out.println("\tD: Add Deposit");
            System.out.println("\tP: Make Payment");
            System.out.println("\tL: Ledger");
            System.out.println("\tX: Exit");
            System.out.println("Please enter a command: ");
            input = scanner.nextLine();

            switch (input.toUpperCase()) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    Ledger();
                    break;
                case "X":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        } while (!input.equalsIgnoreCase("X"));
    }
    private static void addDeposit() {

        System.out.println("Enter the date of the deposit (YYYY-MM-DD): ");
        String Date = scanner.nextLine();

        System.out.println("Enter the time of the deposit (HH-MM-SS): ");
        String Time = scanner.nextLine();

        System.out.println("Please enter any description of the deposit:  ");
        String Description = scanner.nextLine();

        System.out.println("Enter the vendor: ");
        String Vendor = scanner.next();

        System.out.println("Enter the amount of the deposit: ");
        String Amount = scanner.next();

        try {
            FileWriter fileWriter = new FileWriter("./src/main/java/com/mt/transactions.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Date + "|" + Time + "|" + Description + "|" + Vendor + "|" + Amount);
            System.out.println("Deposit has successfully been made.");
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Deposit was unsuccessful, please try again");
            e.printStackTrace();
        }
    }
    private static void makePayment() {

        System.out.println("Enter the date of the payment (YYYY-MM-DD): ");
        String Date = scanner.nextLine();

        System.out.println("Enter the time of the payment (HH-MM-SS): ");
        String Time = scanner.nextLine();

        System.out.println("Please enter any description of the payment:  ");
        String Description = scanner.nextLine();

        System.out.println("Enter the vendor: ");
        String Vendor = scanner.next();

        System.out.println("Enter the amount of the payment: ");
        String Amount = scanner.next();

        try {
            FileWriter fileWriter = new FileWriter("./src/main/java/com/mt/transactions.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Date + "|" + Time + "|" + Description + "|" + Vendor + "|" + Amount);
            System.out.println("Payment has successfully been made.");
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Payment was unsuccessful, please try again");
            e.printStackTrace();
        }
    }
    private static void Ledger() throws FileNotFoundException {

        String input;
        do {
            System.out.println("--Main Menu--");
            System.out.println("\tA) Display all entries");
            System.out.println("\tD) Deposits");
            System.out.println("\tP) Payments");
            System.out.println("\tR) Reports");
            System.out.println("\tH) Home");
            System.out.println("Please enter a command: ");

            input = scanner.nextLine();

            switch (input.toUpperCase()) {
                case "A":
                    displayAllEntries();
                    break;
                case "D":
                    Deposits();
                    break;
                case "P":
                    Payments();
                    break;
                case "R":
                    Reports();
                    break;
                case "H":
                    System.out.println("Exiting back to home screen.");
                    break;
                default:
                    System.out.println("Invalid Input, please try again.");
                    break;
            }

        } while (!input.equalsIgnoreCase("H"));
    }
    private static void displayAllEntries() throws FileNotFoundException {

        Scanner input = new Scanner(new File("./src/main/java/com/mt/transactions.txt"));

        System.out.println("| Date | Time | Description | Vendor | Amount |");

        while (input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }
    }
    private static void Deposits() {
    }
    private static void Payments() {
    }
    private static void Reports() {

        String input;
        do {
            System.out.println("--Reports--");
            System.out.println("\t1) Month To Date");
            System.out.println("\t2) Previous Month");
            System.out.println("\t3) Year To Date");
            System.out.println("\t4) Previous Year");
            System.out.println("\t0) Back");
            System.out.println("Please enter a command: ");

            input = scanner.nextLine();

            switch (input) {

                case "1":
                    monthToDate();
                    break;
                case "2":
                    previousMonth();
                    break;
                case "3":
                    yearToYear();
                    break;
                case "4":
                    previousYear();
                    break;
                case "0":
                    System.out.println("Exiting back to the Main Menu.");
                default:
                    System.out.println("Invalid Input, please try again.");
                    break;
            }

        } while (!input.equalsIgnoreCase("0"));
    }
    private static void monthToDate() {
       //  BeginningOfMonth Create a date LocalDate.now().getYear() + "-" LocalDate.now().getMonth() + "-" 00 + 00:00:00"
       //  givenDateTime > BeginningOfMonth
    }
    private static void previousMonth() {
       //  prevMonth = LocalDate.now().getYear() + "-" LocalDate.now().minusMonths(1).getMonth() + "-" 00 + 00:00:00"
       //  currentMonth = LocalDate.now().getYear() + "-" LocalDate.now().getMonth() + "-" 00 + 00:00:00"
       //  givenDateTime > prevMonth && givenDateTime < currentMonth

    }
    private static void yearToYear() {
        // From the beginning of the year
        // beginningYear = LocalDate.now().getYear() + "-01-01 00:00:00"
        // givenDateTime > beginningYear
    }
    private static void previousYear() {
        // All transactions from last year
        // beginningOfLastYear = LocalDate.now().minusYears(1).getYears() + "-01-01 00:00:00"
        // beginningOfCurrentYear = LocalDate.now().getYear() + "-01-01 00:00:00"

        // givenDateTime > beginningOfLastYear && givenDateTime < beginningOfCurrentYear
    }

}
