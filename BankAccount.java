import java.util.Scanner;

public class BankAccount {
    private String name, password;
    private double balance;

    public BankAccount(String initName, String initPass, double initBalance){
        this.name = initName;
        this.password = initPass;
        this.balance = initBalance;
    }

    public double getBalance(String enteredPassword) {
        if (password.equals(enteredPassword)) {
            return balance;
        } else {
            return -1;
        }
    }

    public boolean setPassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            password = newPassword;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(String enteredPassword, double amount) {
        if(password.equals(enteredPassword) && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(String enteredPassword, double amount) {
        if (password.equals(enteredPassword)) {
            balance += amount;
        }
    }

    public void transfer(BankAccount other, String enteredPassword, double amount) {
        System.out.println("Enter your password: ");
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();

        if (this.withdraw(input,amount)) {
            other.deposit(enteredPassword,amount);
        }

    }
    public static void main(String[] args){
        BankAccount myAccount = new BankAccount("Dovolis' account", "CSCI1933 rules!", 100.50);
        BankAccount myOtherAccount = new BankAccount("Taylor's account", "CSCI1933 sucks!", 10000);

        myAccount.transfer(myOtherAccount, "CSCI1933 sucks!", 100);
        System.out.println(myAccount.balance);
        System.out.println(myOtherAccount.balance);

        // myAccount.password = "CSCI1933 rules!";
        // myAccount.deposit("CSCI1933 rules!", 100.50);
        // System.out.println("My account's balance is: " + myAccount.balance);

        // System.out.println("Enter your password: ");
        // Scanner myScanner = new Scanner(System.in);
        // String input = myScanner.nextLine();

        // System.out.println("Your account balance is: " + myAccount.getBalance(input));

    }

}
