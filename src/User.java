import java.util.*;
import java.time.Instant;

public abstract class User {
    private static int idCounter = 0;
    public final int id;
    private String name;
    private String phoneNumber;
    private String email;
    private Instant creat_ad;



    protected User(String name, String phoneNumber, String email) {
        this.id = ++idCounter;

        if (name.length() >= 3 && name != null) {
            this.name = name;
        }

        if (phoneNumber.matches("^(?:\\+380|0)\\d{9}$")) {
            this.phoneNumber = phoneNumber;
        }

        if (email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
            this.email = email;
        }

        creat_ad = Instant.now();

    }


    public void setName(String name) {
        if (name.length() >= 3) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^(?:\\\\+380|0)\\\\d{9}$")) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        if (email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
            this.email = email;
        }
    }

    public String getEmail() {
        return email;
    }

    public Instant getCreat_ad() {
        return creat_ad;
    }


    public abstract void addNewCart(CreditCart numberOfCart);

    public abstract void deleteCart(CreditCart creditCartNumber);



    @Override
    public String toString() {
        return "Name: " + name +
                "\n" + "Email: " + email +
                "\n" + "PhoneNumber: " + phoneNumber + "\n";
    }
}
