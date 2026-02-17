import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BankAccount extends User{
    private Status accountStatus;
    private Set<CreditCart> creditCarts;



    public BankAccount(String name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
        this.accountStatus = Status.Active;
        this.creditCarts = new HashSet<>();
    }

    @Override
    public void addNewCart(CreditCart cart) {
        creditCarts.add(cart);
    }

    @Override
    public void deleteCart(CreditCart creditCartNumber) {
        Iterator<CreditCart> it = creditCarts.iterator();

        while(it.hasNext()) {
            CreditCart value = it.next();

            if (value.getNumber().equals(creditCartNumber.getNumber())) {
                it.remove();
            }
        }
    }

    public Set<CreditCart> getCreditOfCarts() {
        return creditCarts;
    }

    public Status getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Status status) {
        this.accountStatus = status;
    }
}
