import java.io.*;

public class MyProgram2 {

    public static void main(String[] args){

        boolean isRunning = true;

        try{
            BufferedReader keyboard_reader = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("emp.dat"));
            while(isRunning){
                String emp_name;
                double net_income;
                String choice;
                System.out.println("1.Add a employee");
                System.out.println("2.Close the program");
                System.out.print("Enter here:");
                choice = keyboard_reader.readLine();

                if(choice.equals("1")){
                    System.out.print("Enter the employee's name:");
                    emp_name = keyboard_reader.readLine();
                    System.out.print("Enter the employee's net income:");
                    net_income = Double.parseDouble(keyboard_reader.readLine());
                    outputStream.writeUTF(emp_name + ": ₱" + net_income);
                    outputStream.flush();
                    System.out.println(emp_name + ": ₱" + net_income + "-> written to the emp.dat");
                } else if (choice.equals("2")) {
                    System.out.println("Closing the program...");
                    isRunning = false;
                }

            }
            keyboard_reader.close();
            outputStream.close();
        } catch (Exception e) {
            System.out.println("An exception occurred");
        }


    }
}
