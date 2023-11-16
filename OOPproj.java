package oopproj;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OOPproj {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int MAX_USERS = 10;
        String[] userNames = new String[MAX_USERS];
        String[] passWords = new String[MAX_USERS];
        int[] balances = new int[MAX_USERS];
        String[] Transactions = new String[MAX_USERS]; 
        String[] typeOfCurrency = new String[]{"[1]Pound sterling", "[2]Swiss Franc",
            "[3]Canadian Dollar", "[4]United States Dollar", "[5]Kuwaiti Dinar", "[6]Omani Rial",
            "[7]Euro", "[8]Japanese Yen"};
        double[] exchangeRates = new double[]{68.89, 62.23, 40.63, 56.14, 181.79, 145.87, 60.07, 0.37};
        double convertedAmount;

        int accountCount = 0;

        while (true) {
            System.out.println("\n\n\n\n\n");
            System.out.println("Choose an option:");
            System.out.println("[1] Open an Account");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");
            System.out.println("Enter your choice: ");
            String choice = input.readLine();

            switch (choice) {
                case "1":
                    if (accountCount < MAX_USERS) {
                        accountCount += 1;
                        System.out.print("Please Enter Username: ");
                        String tempUserName = input.readLine();

                        boolean userNameTaken = false;
                        for (int x = 0; x < accountCount; x++) {
                            if (tempUserName.equals(userNames[x])) {
                                userNameTaken = true;
                                break;
                            }
                        }

                        if (!userNameTaken) {
                            userNames[accountCount - 1] = tempUserName;
                            System.out.print("Please Enter Password: ");
                            passWords[accountCount - 1] = input.readLine();
                            System.out.println("Account created successfully!");
                        } else {
                            System.out.println("The username is already taken!");
                        }
                    } else {
                        System.out.println("The maximum users are reached!");
                    }

                    break;

                case "2":
                    System.out.print("Enter your username: ");
                    String loginUsername = input.readLine();
                    System.out.print("Enter your password: ");
                    String loginPassword = input.readLine();

                    boolean loggedIn = false;
                    int index = 0;
                    int amount = 0;

                    for (int i = 0; i < accountCount; i++) {
                        if (loginUsername.equals(userNames[i]) && loginPassword.equals(passWords[i])) {
                            loggedIn = true;
                            index++;
                            break;
                        }
                    }

                    if (loggedIn) {
                        System.out.println("\n\n\n\n\n");
                        System.out.println("Login successful!");
                        System.out.println("[1] Deposit");
                        System.out.println("[2] Withdraw");
                        System.out.println("[3] Loan");
                        System.out.println("[4] Balance");
                        System.out.println("[5] Foreign Exchange");
                        System.out.println("Enter your choice: ");
                        choice = input.readLine();

                        switch (choice) {
                            case "1":
                                System.out.print("Enter the amount to deposit:    ");
                                amount = Integer.parseInt(input.readLine());
                                balances[index] += amount;
                                System.out.println("Deposit successful. New balance: " + balances[index]);
                                break;

                            case "2":
                                System.out.println("Enter the amount to withdraw: ");
                                amount = Integer.parseInt(input.readLine());
                                if (amount > balances[index]) {
                                    System.out.println("Insufficient balance");
                                } else {
                                    balances[index] -= amount;
                                    System.out.println("Withdrawal successful. New balance: " + balances[index]);
                                }
                                break;

                            case "3":
                                System.out.println("wala pa");
                                break;

                            case "4":
                                System.out.println("Your current balance: " + balances[index]);
                                break;
                            case "5":
                                System.out.println("Foreign Exchange");
                                System.out.println("Choose your currency");

                                for (int x = 0; x < typeOfCurrency.length; x++) {
                                    System.out.println(typeOfCurrency[x] + "\t" + exchangeRates[x]);
                                }

                                System.out.print("Enter your choice: ");
                                choice = input.readLine();

                                int chosenCurrencyIndex = Integer.parseInt(choice) - 1;

                                if (chosenCurrencyIndex >= 0 && chosenCurrencyIndex < typeOfCurrency.length) {
                                    System.out.print("Enter the amount of " + typeOfCurrency[chosenCurrencyIndex] + "to convert into peso/s : ");
                                    double Conv_amount = Double.parseDouble(input.readLine());

                                    for (int x = 0; x < typeOfCurrency.length; x++) {
                                        convertedAmount = Conv_amount * exchangeRates[chosenCurrencyIndex];
                                        System.out.println(typeOfCurrency[chosenCurrencyIndex] + ": " + convertedAmount + "Peso/s");
                                        break;
                                    }
                                    Transactions[index]=typeOfCurrency[chosenCurrencyIndex];
                                    
                                } else {
                                    System.out.println("Invalid choice. Please choose a valid currency.");
                                }
                                break;

                            default:
                                System.out.println("Invalid Choice!");
                                break;
                        }
                    } else {
                        System.out.println("Incorrect username or password. Please try again.");
                    }
                    break;

                case "3":
                    System.exit(0);

                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }
    }
}
   

