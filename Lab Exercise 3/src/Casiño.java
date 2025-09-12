import java.util.Scanner;

public class Casiño{


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while(true){

            int month;
            int day;
            int year;

            System.out.print("Enter the month:");
            month = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter the day:");
            day = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter the year:");
            year = scanner.nextInt();
            scanner.nextLine();

            switch(month){
                case 1:
                    System.out.println("January" + " " + day +", " + year);
                    break;
                case 2:
                    System.out.println("February" + " " + day +", " + year);
                    break;
                case 3:
                    System.out.println("March" + " " + day +", " + year);
                    break;
                case 4:
                    System.out.println("April" + " " + day +", " + year);
                    break;
                case 5:
                    System.out.println("May" + " " + day +", " + year);
                    break;
                case 6:
                    System.out.println("June" + " " + day +", " + year);
                    break;
                case 7:
                    System.out.println("July" + " " + day +", " + year);
                    break;
                case 8:
                    System.out.println("August" + " " + day +", " + year);
                    break;
                case 9:
                    System.out.println("September" + " " + day +", " + year);
                    break;
                case 10:
                    System.out.println("October" + " " + day +", " + year);
                    break;
                case 11:
                    System.out.println("November" + " " + day +", " + year);
                    break;
                case 12:
                    System.out.println("December" + " " + day +", " + year);
                    break;
                default:
                    System.out.println("Invalid Month");
            }

            System.out.print("Do you want to keep the program running?(y/n):");
            if(!(scanner.nextLine().equalsIgnoreCase("y"))){
                break;
            }


        }

    }
}
