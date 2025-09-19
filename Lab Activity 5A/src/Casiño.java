import java.util.Scanner;

public class Casiño{

    public static Scanner scanner = new Scanner(System.in);

    public static void maxVal(){

        int num1;
        int num2;
        System.out.print("Enter the first number:");
        num1 = scanner.nextInt();
        System.out.print("Enter the second number:");
        num2 = scanner.nextInt();
        if(num1 > num2){
            System.out.println("The max number is the first number: " + num1);
        }
        else if(num1 < num2){
            System.out.println("The max number is the second number: " + num2);
        }
        else{
            System.out.println("Both numbers are equal in value: " + num1);
        }


    }

    public static void minVal(){
        int num1;
        int num2;
        System.out.print("Enter the first number:");
        num1 = scanner.nextInt();
        System.out.print("Enter the second number:");
        num2 = scanner.nextInt();
        if(num1 < num2){
            System.out.println("The min number is the first number: " + num1);
        }
        else if(num1 > num2){
            System.out.println("The min number is the second number: " + num2);
        }
        else{
            System.out.println("Both numbers are equal in value: " + num1);
        }
    }

    public static void division(){
        int num1;
        int num2;
        System.out.print("Enter the first number:");
        num1 = scanner.nextInt();
        System.out.print("Enter the second number:");
        num2 = scanner.nextInt();
        System.out.printf("The quotient of the two numbers is: %.2f", (double)num1/num2);
    }

    public static void average(){
        int num1;
        int num2;
        System.out.print("Enter the first number:");
        num1 = scanner.nextInt();
        System.out.print("Enter the second number:");
        num2 = scanner.nextInt();
        int sum = num1 + num2;
        System.out.printf("The average of the two numbers is %.2f", (double)sum/2);
    }

    public static void main(String[] args){

        int choice;
        System.out.println("1.Find Maximum Value of two numbers");
        System.out.println("2.Find Minimum Value of two numbers");
        System.out.println("3.Find the quotient of two numbers");
        System.out.println("4.Find the average of two numbers");
        System.out.print("Pick a Computation:");
        choice = scanner.nextInt();

        if(choice == 1){
            maxVal();
        }
        else if(choice == 2){
            minVal();
        }
        else if(choice == 3){
            division();
        }
        else if(choice == 4){
            average();
        }
        else{
            System.out.println("Invalid input");
        }

    }
}
