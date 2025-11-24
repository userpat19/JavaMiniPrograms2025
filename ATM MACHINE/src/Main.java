import java.util.Scanner;


public class Main {

    static void ViewBalance(int money){
        System.out.println("Your account has PHP" + money);
    }

    static int Deposit(int money, int add_amount){
        return money + add_amount;
    }

    static int Withdraw(int money, int minus_amount){
        return money - minus_amount;
    }

    public static void main(String[] args){

        int Balance = 1000;
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning){
            String mode;
            System.out.println("1.View Account Balance ");
            System.out.println("2.Deposit to my account ");
            System.out.println("3.Withdraw from my account");
            System.out.println("4.Exit the machine");
            System.out.print("Enter:");
            mode = scanner.nextLine();

            switch(mode){
                case "1":
                    ViewBalance(Balance);
                    break;

                case "2":
                    System.out.print("Enter the amount of money to deposit:");
                    int add_amount = scanner.nextInt();
                    scanner.nextLine();
                    Balance = Deposit(Balance, add_amount);
                    System.out.println("Deposited Successfully, account balance updated");
                    break;

                case "3":
                    System.out.print("Enter the amount of money to withdraw:");
                    int subtract_amount = scanner.nextInt();
                    scanner.nextLine();
                    Balance = Withdraw(Balance, subtract_amount);
                    System.out.println("Withdrawn Successfully, account balance updated");
                    break;

                case "4":
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid User Input");
            }

        }
    }
}
