import java.time.YearMonth;
import java.util.Objects;
import java.util.Random;

public class CreditCart {
    private static final YearMonth date  = YearMonth.now();

    private Status status;
    private final String number;
    private final String cvv2;
    private final String validThrough;
    private final BankAccount bankAccount;
    private double balance;

    public CreditCart(String number, BankAccount bankAccount) {
        boolean isValid = true;
        this.balance = 0;

        this.validThrough = date.getMonthValue() + "/" + Integer.valueOf((date.getYear() % 100) + 4);

        if (number.trim().matches("^\\d{16}$")) {
            this.number = number;
        } else {
            this.number = null;
            isValid = false;
        };

        this.cvv2 = generateCvv2();

        if (bankAccount != null) {
            this.bankAccount = bankAccount;
        } else {
            this.bankAccount = null;
            isValid = false;
        };

       if (isValid) {
           this.status = Status.Active;
       } else this.status = Status.NoActive;


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;


        CreditCart cart = (CreditCart) o;

        return Objects.equals(number, cart.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private static String generateCvv2() {
        StringBuilder value = new StringBuilder("");
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            value.append(rand.nextInt((9 - 0 ) + 1) + 0);
        }

        return value.toString();
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public String getCvv2() {
        return cvv2;
    }

    public String getValidThrough() {
        return validThrough;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    @Override
    public String toString() {
        return "Number: " + number +
                "\n" + "CVV2: " + cvv2 +
                "\n" + "Valid through: " + validThrough +
                "\n" + "Status: " + status +
                "\n" + "User: " + bankAccount.getEmail();
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
