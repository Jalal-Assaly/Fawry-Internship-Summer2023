import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {

    // Private fields
    private static int counter = 0;     // Counter for automatic account number generation
    private int accountNumber;          // Variable holding the account number
    private final String accountHolderName;     // Holder name cannot change once written
    protected BigDecimal balance;       // Private variable with setter and getter

    // Setters and Getters
    public int getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolderName(){
        return accountHolderName;
    }
    public BigDecimal getBalance(){
        return balance;
    }

    // Constructor Definition
    public Account(String accountHolderName) {
        this.accountNumber = ++counter;    // Increment account number to generate automatically
        this.accountHolderName = accountHolderName;
        this.balance = BigDecimal.ZERO;
    }

    // Methods
    public void depositMoney(BigDecimal money){
        balance = balance.add(money.setScale(2, RoundingMode.DOWN));
    }
    public void withdrawMoney(BigDecimal money) throws Exception {
        if(balance.subtract(money).compareTo(BigDecimal.ZERO) > 0){
            balance = balance.subtract(money.setScale(2, RoundingMode.DOWN));
        } else {
            throw new Exception("Insufficient Balance !");
        }
    }
}
