import java.util.Scanner;

class InvalidPINException extends Exception {
    InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    InvalidAmountException(String message) {
        super(message);
    }
}

class ATM {
    private double balance = 10000;
    private final int correctPIN = 1234;

    void verifyPIN(int pin) throws InvalidPINException {
        if (pin != correctPIN) {
            throw new InvalidPINException("Invalid PIN!");
        }
    }

    void checkBalance() {
        System.out.println("Available Balance: Rs. " + balance);
    }

    void deposit(double amount)
            throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be greater than zero."
            );
        }

        balance += amount;
        System.out.println("Amount deposited successfully.");
        checkBalance();
    }

    void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance!"
            );
        }

        balance -= amount;
        System.out.println("Withdrawal successful.");
        checkBalance();
    }
}

public class ATM_Transaction_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        try {
            System.out.print("Enter your PIN: ");
            int pin = sc.nextInt();

            atm.verifyPIN(pin);
            System.out.println("PIN verified successfully!");

            int choice;

            do {
                System.out.println("\n--- ATM MENU ---");
                System.out.println("1. Balance Enquiry");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                try {
                    switch (choice) {
                        case 1:
                            atm.checkBalance();
                            break;

                        case 2:
                            System.out.print(
                                "Enter deposit amount: "
                            );
                            double deposit = sc.nextDouble();
                            atm.deposit(deposit);
                            break;

                        case 3:
                            System.out.print(
                                "Enter withdrawal amount: "
                            );
                            double withdraw = sc.nextDouble();
                            atm.withdraw(withdraw);
                            break;

                        case 4:
                            System.out.println("Thank you!");
                            break;

                        default:
                            System.out.println(
                                "Invalid menu choice."
                            );
                    }
                } catch (InvalidAmountException |
                         InsufficientBalanceException e) {
                    System.out.println(
                        "Error: " + e.getMessage()
                    );
                }

            } while (choice != 4);

        } catch (InvalidPINException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println(
                "Error: Please enter numbers only."
            );
        } finally {
            sc.close();
            System.out.println("ATM session ended.");
        }
    }
}
