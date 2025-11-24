import java.util.Scanner;
import java.io.*;

public class ReadEmp {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        try{
            DataInputStream in = new DataInputStream(new FileInputStream("C:\\Users\\Pat's PC\\Downloads\\emp.dat"));
            String line;
            for(int x = 0; x < 5; x++){
                line = in.readUTF();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found error");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }
}
