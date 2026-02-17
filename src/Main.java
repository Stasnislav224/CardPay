
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Integer, BankAccount> users = new HashMap<>();

        BankAccount user = new BankAccount("user1", "0631234567", "user2@gmail.com");
        BankAccount user2 = new BankAccount("user2", "0631234569", "user4@gmail.com");

        CreditCart cart = new CreditCart("4111111111111111", user);
        CreditCart cart2 = new CreditCart("4111111111111112", user2);

        user.addNewCart(cart);
        user2.addNewCart(cart2);

        System.out.println("");


        Transaction.deposit(cart2, 100);
        Transaction.cartToCart(cart2, cart, 100);
    }
}

//


