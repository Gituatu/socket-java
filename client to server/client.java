import java.net.*;
import java.io.*;

public class client{
    public static void main(String[] args) throws IOException{
        Socket s= new Socket("localhost", 4999);

        PrintWriter gf = new PrintWriter(s.getOutputStream());
        gf.println("hello");
        gf.flush();
    }
}