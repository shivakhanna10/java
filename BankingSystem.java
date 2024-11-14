// Customer class
class Customer {
    private String name;
    private String customerID;
    public Customer(String name, String customerID) {
        this.name = name;
        this.customerID = customerID;
    }
    public String getName() {
        return name;
    }
    public String getCustomerID() {
        return customerID;
    }
}
// Account class (Superclass)
class Account {
    private String accountNumber;
    private double balance;
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
// SavingsAccount subclass (Specialization)
class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
}
// CheckingAccount subclass (Specialization)
class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
}
// Main class to run the Banking System
public class BankingSystem {
    public static void main(String[] args) {
        // Creating a customer and accounts
        Customer customer1 = new Customer("Alice", "C001");
        Account savingsAccount = new SavingsAccount("S123", 500.0);
        Account checkingAccount = new CheckingAccount("C123", 1000.0);

        // Performing a deposit and withdrawal
        savingsAccount.deposit(200.0);
        System.out.println("New balance in savings account: $" + savingsAccount.getBalance());

        checkingAccount.withdraw(300.0);
        System.out.println("New balance in checking account: $" + checkingAccount.getBalance());
    }
}
