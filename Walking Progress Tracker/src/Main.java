import java.util.Scanner;

public class Main {

    public static void Add_Exercise_Data(int day, Integer[] arr, Scanner sc){
        String actual_day;
        if(day == 1){
            actual_day = "Monday";
        }
        else if(day == 2){
            actual_day = "Tuesday";
        }
        else if(day == 3){
            actual_day = "Wednesday";
        }
        else if(day == 4){
            actual_day = "Thursday";
        }
        else if(day == 5){
            actual_day = "Friday";
        }
        else if(day == 6) {
            actual_day = "Saturday";
        }
        else{
            actual_day = "Sunday";
        }
        int steps;
        System.out.print("Enter the amount of steps you took for this day:");
        steps = sc.nextInt();
        sc.nextLine();
        arr[day - 1] = steps;
        System.out.println("You took " + steps + " steps on " + actual_day);
    }

    public static void Display_Exercises_Data(Integer[] arr){

        System.out.println("--RECORDED EXERCISE DATA--");
        if(arr[0] != null){
            System.out.println("Monday: " + arr[0] + " steps");

        }else{
            System.out.println("Monday: No record yet");
        }

        if(arr[1] != null){
            System.out.println("Tuesday: " + arr[1] + " steps");

        }else{
            System.out.println("Tuesday: No record yet");
        }

        if(arr[2] != null){
            System.out.println("Wednesday: " + arr[2] + " steps");

        }else{
            System.out.println("Wednesday: No record yet");
        }

        if(arr[3] != null){
            System.out.println("Thursday: " + arr[3] + " steps");

        }else{
            System.out.println("Thursday: No record yet");
        }
        if(arr[4] != null){
            System.out.println("Friday: " + arr[4] + " steps");

        }else{
            System.out.println("Friday: No record yet");
        }
        if(arr[5] != null){
            System.out.println("Saturday: " + arr[5] + " steps");

        }else{
            System.out.println("Saturday: No record yet");
        }
        if(arr[6] != null){
            System.out.println("Sunday: " + arr[6] + " steps");

        }else{
            System.out.println("Sunday: No record yet");
        }


    }

    public static void Main_Menu(){

        //example: steps_progress[0] = 90, this means that the user took 90 steps in monday(the first index of the array)
        Integer[] steps_progress = new Integer[7];

        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;

        while(isRunning){

            System.out.println("1.Add exercise data for a specific day");
            System.out.println("2.Display all exercise data");
            System.out.println("3.Calculate weekly average");
            System.out.println("4.Display the best exercise day");
            System.out.println("5.Exit");
            System.out.print("Enter here:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    int day;
                    System.out.print("Enter the day(1 for Monday, 2 for Tuesday and so on): ");
                    day = scanner.nextInt();
                    scanner.nextLine();
                    if(!(day >= 1 && day <= 7)){
                        System.out.println("Invalid Day");
                        break;
                    }
                    if(steps_progress[day - 1] == null){
                        Add_Exercise_Data(day, steps_progress, scanner);
                    }else{
                        String replace;
                        System.out.print("There is a recorded step on this day, do you want to replace it?(y/n)");
                        replace = scanner.nextLine();
                        if(replace.equalsIgnoreCase("y")){
                            Add_Exercise_Data(day, steps_progress, scanner);
                        }else{
                            System.out.println("Going back to main menu....");
                        }
                    }

                    break;
                case 2:
                    Display_Exercises_Data(steps_progress);
                    break;
                case 3:
                    System.out.println("Picked 3");
                    break;
                case 4:
                    System.out.println("Picked 4");
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }

        }

    }

    public static void main(String[] args){

        Main_Menu();

    }
}
