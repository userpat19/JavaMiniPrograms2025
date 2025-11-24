import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;


public class FactorialServer {

    static int get_Factorial(int num){
        if(num > 0){
            return num * get_Factorial(num - 1);
        }

        return 1;
    }

    public static void main(String[] args){



        try{
            System.out.println("Waiting for client connection request");
            ServerSocket serverSocket = new ServerSocket(9806);
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connected Successfully");
            int the_num = Integer.parseInt(reader.readLine());
            out.println("Server says: the factorial of " + the_num + " is " + get_Factorial(the_num));
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
