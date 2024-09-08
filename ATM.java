import java.util.Scanner;

public class ATM {
    private int pin = 1234; // Default PIN
    private double balance = 1000.00; // Default balance
    
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean authenticated = false;
        
        while (!authenticated) {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();
            
            if (authenticate(enteredPin)) {
                authenticated = true;
                System.out.println("Authentication successful!");
                showMenu();
            } else {
                System.out.println("Invalid PIN. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    private boolean authenticate(int enteredPin) {
        return enteredPin == pin;
    }
    
    private void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Exiting. Thank you for using our ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
    
    private void checkBalance() {
        System.out.printf("Your balance is $%.2f\n", balance);
    }
    
    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0) {
            balance += amount;
            System.out.printf("You have successfully deposited $%.2f\n", amount);
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }
    
    private void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("You have successfully withdrawn $%.2f\n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }
}
