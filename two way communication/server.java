import java.net.*;
import java.io.*;

public class server{
    public static void main(String[] args) throws IOException{
        ServerSocket ss= new ServerSocket(4999);
        Socket s= ss.accept();

        System.out.println("client connected");

        InputStreamReader in= new InputStreamReader(s.getInputStream());

        BufferedReader bf= new BufferedReader(in, 3);

        String str= bf.readLine();
        System.out.println("server: "+ str);

        PrintWriter gf = new PrintWriter(s.getOutputStream());
        gf.println("It's me Client");
        gf.flush();
    
    }
}