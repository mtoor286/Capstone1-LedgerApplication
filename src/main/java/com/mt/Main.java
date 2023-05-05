package com.mt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        String input;
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

        System.out.println("Please enter any description of the payment: ");
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
    private static void Ledger() throws IOException {

        String input;
        do {
            System.out.println("--Ledger Menu--");
            System.out.println("\tA) Display all entries");
            System.out.println("\tD) Deposits");
            System.out.println("\tP) Payments");
            System.out.println("\tR) Reports");
            System.out.println("\tH) Home");
            System.out.println("Please enter a command: ");

            input = scanner.nextLine();

            switch (input.toUpperCase()) {
                case "A":
                    displayAllTransactions();
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
    private static void displayAllTransactions() throws FileNotFoundException {

        Scanner input = new Scanner(new File("./src/main/java/com/mt/transactions.txt"));

        System.out.println("| Date | Time | Description | Vendor | Amount |");

        while (input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }
    }
    private static void Deposits() throws IOException {

            FileReader fileReader = new FileReader("./src/main/java/com/mt/transactions.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linesFromFile;

            while ((linesFromFile = bufferedReader.readLine()) != null) {

                String[] numbers = linesFromFile.split(linesFromFile);
                int num = 0;
                boolean hasPositive = (num > 0);

                for (String number : numbers) {
                    num = Integer.parseInt(number);
                    if (num < 0) {
//                        hasPositive;
                        break;
                    }
                }
            }
            fileReader.close();
            bufferedReader.close();
    }
    private static void Payments() throws IOException {

        FileReader fileReader = new FileReader("./src/main/java/com/mt/transactions.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linesFromFile;

        while ((linesFromFile = bufferedReader.readLine()) != null) {

            String[] numbers = linesFromFile.split(linesFromFile);
            int num = 0;
            boolean hasNegative = (num < 0);

            for (String number : numbers) {
                num = Integer.parseInt(number);
                if (num < 0) {
//                        hasNegative;
                    break;
                }
            }
        }
        fileReader.close();
        bufferedReader.close();
    }
    private static void Reports() {

        String input;
        do {
            System.out.println("--Reports Menu--");
            System.out.println("\t1) Month to Date");
            System.out.println("\t2) Previous Month");
            System.out.println("\t3) Year to Date");
            System.out.println("\t4) Previous Year");
            System.out.println("\t5) Search by Vendor");
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
                case "5":
                    searchByVendor();
                    break;
                case "0":
                    System.out.println("Exiting back to the Main Menu.");
                default:
                    System.out.println("Invalid Input, please try again.");
                    break;
            }

        } while (!input.equalsIgnoreCase("0"));
    }
    private static void searchByVendor() {

        File file = new File("./src/main/java/com/mt/transactions.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Vendor name your looking for: ");
        String name = scanner.next();

        try {
            scanner = new Scanner(file);

            System.out.println("Transactions under this Vendor: ");
            System.out.println("| Date | Time | Description | Vendor | Amount |");

            while (scanner.hasNext()) {

                final String linesFromFile = scanner.nextLine();
                if (linesFromFile.contains(name)) {

                    System.out.println(linesFromFile);
                }

            }
            System.out.println("End of List.");

        } catch (IOException e) {
            System.out.println("Vendor name not found, please try again.");
            e.printStackTrace();
        }
    }
    private static void monthToDate() {

        String date = "2023-05-10";
        String time = "10:13:25";
        String dateTime = date + " " + time;

        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();

        LocalDateTime transactionDateTime = null;
        int transactionYear = transactionDateTime.getYear();
        int transactionMonth = transactionDateTime.getMonthValue();

        if(currentYear == transactionYear && currentMonth == transactionMonth){
            System.out.println("Magic!!!");
        }
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
