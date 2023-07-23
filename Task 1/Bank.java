import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    // Getter
    public ArrayList<Account> getAccounts(){
        return accounts;
    }
    public void addNewAccount(String holderName) {
        // Create new instance of account
        Account newAccount = new Account(holderName);

        // Add new account to array of accounts
        accounts.add(newAccount);
    }

    public void addNewSavingsAccount(String holderName, BigDecimal interest) {
        // Create new instance of savings account
        Account newSavingsAccount = new SavingsAccount(holderName, interest);

        // Add new savings account to array of accounts
        accounts.add(newSavingsAccount);
    }

    public void depositMoney(int accountNumber, BigDecimal amount) throws Exception {
        Account account = findAccount(accountNumber);
        account.depositMoney(amount);
    }

    public void withdrawMoney(int accountNumber, BigDecimal amount) throws Exception{
        Account account = findAccount(accountNumber);
        account.withdrawMoney(amount);
    }

    public BigDecimal calculateInterest(int accountNumber) throws Exception{
        Account account = findAccount(accountNumber);   // Down casting

        if (account instanceof SavingsAccount){
            return ((SavingsAccount) account).calculateInterest();
        } else {
            throw new Exception("This account is not a saving account.");
        }
    }

    public BigDecimal getBalance(int accountNumber) throws Exception{
        Account account = findAccount(accountNumber);
        return account.getBalance();
    }

    public Account getAccountInfo(int accountNumber) throws Exception{
        Account account = findAccount(accountNumber);
        return account;
    }

    public Account findAccount(int accountNumber) throws Exception {
        Optional<? extends Account> optionalAccount = accounts.stream()
                .filter(account -> account.getAccountNumber() == accountNumber)
                .findFirst();

        if(optionalAccount.isPresent()){
            return optionalAccount.get();
        } else {
            throw new Exception("Account Not Found !");
        }
    }
}