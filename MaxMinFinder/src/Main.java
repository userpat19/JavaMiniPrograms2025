import java.util.Scanner;

public class Main {

    public static  void main(String[] args){
        int maximum;
        int minimum;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of numbers you want to store:");
        int length_of_array = scanner.nextInt();
        scanner.nextLine();
        int[] numbers = new int[length_of_array];
        System.out.print("Enter number 1:");
        maximum = scanner.nextInt();
        minimum = maximum;

        for(int x = 1; x < length_of_array; x++){
            System.out.print("Enter number " + (x + 1) + ":");
            numbers[x] = scanner.nextInt();
            if(numbers[x] > maximum){
                maximum = numbers[x];
            }
            if(numbers[x] < minimum){
                minimum = numbers[x];
            }
        }

        System.out.println("Maximum:" + maximum);
        System.out.println("Minimum:" + minimum);


        scanner.close();
    }
}
