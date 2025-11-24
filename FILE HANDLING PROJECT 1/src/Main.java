//Project Idea: Student Record Management System

import java.io.*;
import javax.swing.JOptionPane;

public class Main {

    static void ADD_STUDENT(BufferedReader reader, PrintWriter writer, DataOutputStream output) {
        int stud_id;
        String stud_name;
        String course;
        double gpa;
        try {
            System.out.print("Enter student ID:");
            stud_id = Integer.parseInt(reader.readLine());
            System.out.print("Enter student NAME:");
            stud_name = reader.readLine();
            System.out.print("Enter student COURSE:");
            course = reader.readLine();
            System.out.print("Enter student GPA:");
            gpa = Double.parseDouble(reader.readLine());

            writer.println("ID: " + stud_id + ", Name: " + stud_name + ", Course: " + course + ", GPA: " + gpa);
            writer.flush();
            output.writeUTF("ID: " + stud_id + ", Name: " + stud_name + ", Course: " + course + ", GPA: " + gpa);
            output.flush();
        } catch (IOException e) {
            System.out.println("IO Exception occurred");
        }

    }

    public static void main(String[] args) {

        try {

            BufferedReader keyboard_reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter text_writer = new PrintWriter(new FileOutputStream("C:\\Users\\Pat's PC\\IdeaProjects\\JAVA_PROJECTS\\FILE HANDLING PROJECT 1\\src\\STUDENT_DETAILS_TEXT.txt"));
            DataOutputStream binary_writer = new DataOutputStream(new FileOutputStream("C:\\Users\\Pat's PC\\IdeaProjects\\JAVA_PROJECTS\\FILE HANDLING PROJECT 1\\src\\STUDENT_DETAILS_BINARY.dat"));

            boolean isRunning = true;

            while (isRunning) {
                String choice;
                System.out.println("1.ADD A STUDENT DETAILS");
                System.out.println("2.CLOSE PROGRAM");
                System.out.print("ENTER CHOICE HERE:");
                choice = keyboard_reader.readLine();

                switch (choice) {
                    case "1":
                        System.out.println("--FILL UP STUDENT DETAILS--");
                        System.out.println();
                        ADD_STUDENT(keyboard_reader, text_writer, binary_writer);
                        break;
                    case "2":
                        System.out.println("PROGRAM IS CLOSING...");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("INVALID CHOICE");
                }
            }

            keyboard_reader.close();
            text_writer.close();
            binary_writer.close();

        } catch (IOException e) {
            System.out.println("IO Exception occurred");

        }
    }

}
