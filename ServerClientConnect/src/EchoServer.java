import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

public class EchoServer{

    public static void main(String[] args){

        try{
            ServerSocket serverSocket = new ServerSocket(9806);
            System.out.println("Waiting for connection");
            Socket socket = serverSocket.accept();
            System.out.println("Connection established");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(reader.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}