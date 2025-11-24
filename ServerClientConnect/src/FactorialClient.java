import java.io.*;
import java.net.Socket;

public class FactorialClient {

    public static void main(String[] args){

        try{
            System.out.println("Client is starting");
            Socket client_socket = new Socket("localhost", 9806);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
            PrintWriter out = new PrintWriter(client_socket.getOutputStream(), true);
            System.out.print("Enter a number: ");
            out.println(reader.readLine());
            System.out.println(reader1.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
