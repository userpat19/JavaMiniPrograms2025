import java.io.*;
import java.net.Socket;

public class EchoClient{

    public static void main(String[] args){
        try{
            System.out.println("Client Started");
            Socket client_socket = new Socket("localhost", 9806);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
            PrintWriter out = new PrintWriter(client_socket.getOutputStream(), true);
            System.out.print("Enter a string to be sent to the server:");
            out.println(reader.readLine());
            System.out.println("Server echoed the string:" + reader1.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}