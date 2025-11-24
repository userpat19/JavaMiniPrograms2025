import java.io.*;

public class MyProgram {

    public static void main(String[] args){

        try{
            PrintWriter outStream = new PrintWriter(new FileOutputStream("PLC.txt"));
            outStream.println("THIS IS THE NEW CONTENT OF THE FILE.");
            System.out.println("Successfully written to PLC.txt");
            outStream.close();
        }
        catch(IOException e){
            System.out.println("IO exception occurred");
        }


    }
}
