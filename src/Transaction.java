import java.time.LocalDateTime;


public class Transaction {
    private static Status status;


    public static void deposit(CreditCart cart, double amount) {
        try {
            status = Status.Pending;
            if (cartIsActive(cart)) {
                cart.setBalance(cart.getBalance() + amount);
                status = Status.Completed;
            } else throw new Error("Поповнити кратку неможливо тому що вона заблокована");
        } catch(Error e) {
            System.out.println("error message: " + e.getMessage());
            status = Status.Failed;
        } finally {
           String check = getCheck(status, cart, cart.getBankAccount(), "to deposit money", amount);
           System.out.println(check);
        }
    }

    public static void withdraw(CreditCart cart, double amount) {
        try {
            status = Status.Pending;
            if (cartIsActive(cart) && cart.getBalance() >= amount) {
                cart.setBalance(cart.getBalance() - amount);
                status = Status.Completed;
            } else throw new Error("Зняти кошти не вийшло, картка або заблокована або на ній не достатньо коштів");
        } catch(Error e) {
            System.out.println("error message: " + e.getMessage());
            status = Status.Failed;
        }finally {
            getCheck(status, cart, cart.getBankAccount(), "to withdraw money", amount);
        }
    };


    public static void cartToCart(CreditCart cart1, CreditCart cart2, double amount) {
        try {
            status = Status.Pending;
            if (cartIsActive(cart1) && cartIsActive(cart2)) {

                if (cart1.getBalance() >= amount) {
                    cart1.setBalance(cart1.getBalance() - amount);
                } else {
                    throw new Error("Не вийшло зняти кошти, на карті не достатньо грошей");
                }

                cart2.setBalance(cart2.getBalance() + amount);
                status = Status.Completed;
            } else throw new Error("Щось пішло не так, або з карткою відправника або з карткою отримувача");
        } catch (Error e) {
            status = Status.Failed;
            System.out.println("error message: " + e.getMessage());
        } finally {
            String check = getCheck(
                    status,
                    cart1,
                    cart2,
                    cart1.getBankAccount(),
                    cart2.getBankAccount(), "transfer to a card", amount);

            System.out.println(check);
        }
    }



    private static String getCheck(Status status, CreditCart cart, BankAccount account, String action, double amount) {
        return "Status: " + status + "\n" +
                "Action: "+ action  + " sum " + amount + "\n" +
                "Data: "+ LocalDateTime.now()  + "\n" +
                "Cart: " + cart.getNumber() + "\n" +
                account.toString();
    }

    private static String getCheck(Status status, CreditCart cart1, CreditCart cart2, BankAccount account1, BankAccount account2, String action, double amount) {
        return "Status: " + status + "\n" +
                "Action: "+ action  + " sum " + amount + "\n" +
                "Data: "+ LocalDateTime.now()  + "\n" +
                "From cart: " + cart1.getNumber() + "\n" +
                "To cart: " + cart2.getNumber() + "\n" +
                account1.toString() + "\n" +
                account2.toString();
    }

    private static boolean cartIsActive(CreditCart cart) {
        return cart.getStatus().equals(Status.Active);
    }
}