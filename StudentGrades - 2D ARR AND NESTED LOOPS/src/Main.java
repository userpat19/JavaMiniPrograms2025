import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int num_students;
        int num_subjects;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students you want to store:");
        num_students = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the number subject that a student have:");
        num_subjects = scanner.nextInt();
        scanner.nextLine();
        int[][] STUDENTS = new int[num_students][num_subjects];
        String[] names = new String[num_students];

        for(int x = 0; x < num_students; x++ ){

            System.out.print("Enter the name of Student#" + (x + 1) + ":");
            names[x] = scanner.nextLine();

            for(int y = 0; y < num_subjects; y++){
                System.out.print("Enter " + names[x] +"'s grade" + " for subject#" + (y + 1) + ":");
                STUDENTS[x][y] = scanner.nextInt();
                scanner.nextLine();
            }
        }

        System.out.println("Grades Table:");
        for(int x = 0; x < num_students; x++){
            int sum = 0;
            double avg;
            for(int y = 0; y < num_subjects; y++){
                sum += STUDENTS[x][y];
            }
            avg = (double) sum / num_subjects;
            System.out.print(names[x] + ": ");
            for(int grade : STUDENTS[x]){
                System.out.print(grade + " ");
            }
            System.out.print(" | ");
            System.out.println("Average: " + avg);
        }






        scanner.close();
    }
}
