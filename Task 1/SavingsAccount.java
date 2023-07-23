import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount extends Account {
    final BigDecimal interestRate;

    // Getter
    BigDecimal getInterestRate() {
        return interestRate;
    }

    // Constructor
    public SavingsAccount(String accountHolderName, BigDecimal interest) {
        super(accountHolderName);
        this.interestRate = interest.setScale(2, RoundingMode.DOWN);
    }
    // Method
    public BigDecimal calculateInterest(){
        BigDecimal interest = balance.multiply(interestRate).setScale(2, RoundingMode.DOWN);
        return interest;
    }
}
