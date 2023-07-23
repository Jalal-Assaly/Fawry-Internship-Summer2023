import java.math.BigDecimal;
import java.util.Scanner;

public class BankApplication {

    public static String getStringInput(Scanner scanner, String prompt){
        String input;
        while (true){
            System.out.println(prompt);
            input = scanner.nextLine();

            if(input.matches("[a-zA-Z]+\\s[a-zA-Z]+")){
                break;
            }
            else{
                System.out.println("Invalid input. Use alphabetical letters only.");
            }
        }
        return input;
    }

    public static int getIntInput(Scanner scanner, String prompt){
        int input;
        while (true){
            System.out.println(prompt);
            try{
                input = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Use numbers only.");
                scanner.nextLine(); // jumps the newline character
            }
        }
        scanner.nextLine(); // jumps the newline character
        return input;
    }

    public static BigDecimal getBigDecimalInput(Scanner scanner, String prompt){
        BigDecimal input;
        while (true){
            System.out.println(prompt);
            try{
                input = scanner.nextBigDecimal();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Use digit numbers only.");
                scanner.nextLine(); // jumps the newline character
            }
        }
        scanner.nextLine(); // jumps the newline character
        return input;
    }


    public static void main(String[] args) {
        System.out.println("Welcome to your new banking system application !");
        Bank myBank = new Bank();

        // Initialize Scanner
        Scanner scanner = new Scanner(System.in);

        while(true){
            // Navigate the context menu
            System.out.println("To navigate, press the required number: ");
            System.out.println("1. Add new account");
            System.out.println("2. Add new savings account");
            System.out.println("3. Deposit into account");
            System.out.println("4. Withdraw from account");
            System.out.println("5. Calculate interest rate on savings balance (for Savings account)");
            System.out.println("6. Display account information");
            System.out.println("7. Display bank summary");
            System.out.println("8. Close Application\n");

            // Validate Choice
            int choice = getIntInput(scanner, "Your choice: ");

            int accountNumber;
            String holderName;
            BigDecimal amount;
            BigDecimal interestRate;

            switch (choice) {
                case 1 -> {
                    // Input Account holder name
                    holderName = getStringInput(scanner, "Please introduce the new account holder name: ");
                    myBank.addNewAccount(holderName);

                    // Confirmation message
                    System.out.println("New account successfully created !\n");
                }
                case 2 -> {
                    // Input Account holder name
                    holderName = getStringInput(scanner, "Please introduce the new account holder name: ");
                    // Input Account initial balance
                    interestRate = getBigDecimalInput(scanner, "Please introduce the new savings account interest rate: ");
                    myBank.addNewSavingsAccount(holderName, interestRate);

                    // Confirmation message
                    System.out.println("New account successfully created !\n");
                }
                case 3 -> {
                    // Display message
                    accountNumber = getIntInput(scanner,"Please introduce the account number: ");
                    amount = getBigDecimalInput(scanner,"Please introduce the money to be added: ");

                    try {
                        myBank.depositMoney(accountNumber, amount);
                        BigDecimal newBalance = myBank.getBalance(accountNumber);
                        System.out.println(amount + " have been successfully added to your account. " +
                                "Your new balance is: " + newBalance + "\n");
                    } catch (Exception e) {
                        // handle the exception here
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    // Display message
                    accountNumber = getIntInput(scanner,"Please introduce the account number: ");
                    amount = getBigDecimalInput(scanner,"Please introduce the money to be withdrawn: ");


                    try {
                        myBank.withdrawMoney(accountNumber, amount);
                        BigDecimal newBalance = myBank.getBalance(accountNumber);
                        System.out.println(amount + " have been successfully withdrawn to your account. " +
                                "Your new balance is: " + newBalance + "\n");
                    } catch (Exception e) {
                        // handle the exception here
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    // Display message
                    accountNumber = getIntInput(scanner,"Please introduce the account number: ");

                    try {
                        myBank.calculateInterest(accountNumber);
                        BigDecimal interest = myBank.calculateInterest(accountNumber);
                        System.out.println("The interest on saving account is: " + interest + "\n");
                    } catch (Exception e) {
                        // handle the exception here
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    // Display message
                    accountNumber = getIntInput(scanner,"Please introduce the account number: ");

                    try {
                        Account account = myBank.getAccountInfo(accountNumber);
                        System.out.println("Account Number: " + accountNumber);
                        System.out.println("Holder Name: " + account.getAccountHolderName());
                        System.out.println("Balance: " + account.getBalance());
                        if(account instanceof SavingsAccount) {System.out.println("Interest Rate: " +
                                ((SavingsAccount) account).getInterestRate() + "\n");}
                    } catch (Exception e) {
                        // handle the exception here
                        System.out.println(e.getMessage());
                    }
                }
                case 7 -> {
                    if(myBank.getAccounts().isEmpty()){
                        System.out.println("No account has been created yet.");
                    } else {
                        for(Account account: myBank.getAccounts()){
                        System.out.println("Account Number: " + account.getAccountNumber() +
                                "      Type: " + account.getClass().getName() +
                                "      Holder Name: " + account.getAccountHolderName() +
                                "      Balance: " + account.getBalance());
                        }
                    }
                }
                case 8 -> {
                    System.out.println("Thank you for using our application.");
                    System.exit(0);
                }
            }

            // Reset scanner content and pointer
            scanner = new Scanner(System.in);

            // Wait for ENTER key press to resume the program
            System.out.println("Press Enter to resume");
            scanner.nextLine();
        }
    }
}