import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client{
    public static void main(String[] args) {
        Socket socket= null;
        InputStreamReader inputStreamReader= null;
        OutputStreamWriter outputStreamWriter= null;
        BufferedReader bufferedReader= null;
        BufferedWriter bufferedWriter= null;

        try{
            socket= new Socket("localhost",9000);

            inputStreamReader= new InputStreamReader(socket.getInputStream());
            outputStreamWriter= new OutputStreamWriter(socket.getOutputStream());

            bufferedReader= new BufferedReader(inputStreamReader);
            bufferedWriter= new BufferedWriter(outputStreamWriter);

            Scanner scanner= new Scanner(System.in);

            while(true){

                String msgtosend= scanner.nextLine();

                bufferedWriter.write(msgtosend);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                System.out.println("Server: "+ bufferedReader.readLine());

                if(msgtosend.equalsIgnoreCase("bye"))
                    break;
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(socket != null)
                    socket.close();
                if(inputStreamReader !=null)
                    inputStreamReader.close();
                if(outputStreamWriter !=null)
                    outputStreamWriter.close();
                if(bufferedReader !=null)
                    bufferedReader.close();
                if(bufferedWriter !=null)
                    bufferedWriter.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}