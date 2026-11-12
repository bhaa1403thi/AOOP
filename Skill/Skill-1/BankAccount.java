public class BankAccount {
    int accountNumber;
    String accountHolderName;
    double balance;

    BankAccount(int accNum, String accHolderName, double bal) {
        accountNumber = accNum;
        accountHolderName = accHolderName;
        balance = bal;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited :" + balance);
    }

    void withdrawal(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(1001, "Rahul", 5000.0);
        BankAccount b2 = new BankAccount(1002, "Priya", 10000.0);

        b1.displayDetails();
        b1.deposit(2000.0);
        b1.withdrawal(12000.0);
        System.out.println("-------------------");
        b2.displayDetails();
        b2.deposit(5000.0);
        b2.withdrawal(3000.0); 
    }

}