import java.util.Scanner;

public class Main{

    public static int AddNum(int num1, int num2){
        return num1 + num2;
    }

    public static int SubtractNum(int num1, int num2){
        return num1 - num2;
    }

    public static int MultiplyNum(int num1, int num2){
        return num1 * num2;
    }

    public static double DivideNum(int num1, int num2){
        return (double) num1 / num2;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("Calculator Program");
            System.out.println("1.Add two numbers");
            System.out.println("2.Subtract two numbers");
            System.out.println("3.Multiply two numbers");
            System.out.println("4.Divide two numbers");
            System.out.println("5.Close the Program");
            System.out.print("Enter choice:");
            choice = scanner.nextInt();

            if(choice == 1){
                int number1;
                int number2;
                System.out.print("Enter the first number:");
                number1 = scanner.nextInt();
                System.out.print("Enter the second number:");
                number2 = scanner.nextInt();
                System.out.println("The sum of " + number1 + " and " + number2 + " is " + AddNum(number1, number2));
            }
            else if(choice == 2){
                int number1;
                int number2;
                System.out.print("Enter the first number:");
                number1 = scanner.nextInt();
                System.out.print("Enter the second number:");
                number2 = scanner.nextInt();
                System.out.println("The difference of " + number1 + " and " + number2 + " is " + SubtractNum(number1, number2));
            }
            else if(choice == 3){
                int number1;
                int number2;
                System.out.print("Enter the first number:");
                number1 = scanner.nextInt();
                System.out.print("Enter the second number:");
                number2 = scanner.nextInt();
                System.out.println("The product of " + number1 + " and " + number2 + " is " + MultiplyNum(number1, number2));
            }
            else if(choice == 4){
                int number1;
                int number2;
                System.out.print("Enter the first number:");
                number1 = scanner.nextInt();
                System.out.print("Enter the second number:");
                number2 = scanner.nextInt();
                System.out.printf("The quotient of " + number1 + " and " + number2 + " is " + "%.3f", DivideNum(number1, number2));
                System.out.println();
            }
            else if(choice == 5){
                System.out.println("Thank you for running the program");
                break;
            }
            else{
                System.out.println("Invalid choice, please try again");
            }
        }

        scanner.close();
    }
}
