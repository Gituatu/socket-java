import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server{
    public static void main(String[] args) throws IOException {
        Socket socket= null;
        InputStreamReader inputStreamReader= null;
        OutputStreamWriter outputStreamWriter= null;
        BufferedReader bufferedReader= null;
        BufferedWriter bufferedWriter= null;
        ServerSocket serverSocket= null;

        serverSocket= new ServerSocket(9000);

        while(true){
            try{
            
                socket= serverSocket.accept();

                inputStreamReader= new InputStreamReader(socket.getInputStream());
                outputStreamWriter= new OutputStreamWriter(socket.getOutputStream());
    
                bufferedReader= new BufferedReader(inputStreamReader);
                bufferedWriter= new BufferedWriter(outputStreamWriter);
                
                while(true){
                    String msgfromclient= bufferedReader.readLine();
                    System.out.println("Client:"+ msgfromclient);
    
                    bufferedWriter.write("Msg Recived");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
    
                    if(msgfromclient.equalsIgnoreCase("bye"))
                        break;
                }
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();
                //serverSocket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
    }
}