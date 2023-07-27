import java.net.*;
import java.io.*;

public class client{
    public static void main(String[] args) throws IOException{
        Socket s= new Socket("localhost", 4999);

        PrintWriter gf = new PrintWriter(s.getOutputStream());
        gf.println("Oooo Acha");
        gf.flush();

        InputStreamReader in= new InputStreamReader(s.getInputStream());

        BufferedReader bf= new BufferedReader(in, 3);

        String str= bf.readLine();
        System.out.println("client: "+ str);
    }
}