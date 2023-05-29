//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.net.Socket;
//import java.io.*;
//import java.net.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Scanner;
//
//public class Client {
//    public static void main(String[] args) throws IOException {
//        String message;
//        String modmessage; //this is the joke
//
//        InputStreamReader inputStreamReader = null;
//        OutputStreamWriter outputStreamWriter = null;
//        BufferedReader fromClient = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {
//            try {
//                Socket socket = new Socket("localhost", 9127);
//                DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
//                BufferedWriter bufferedWriter = null;
//                BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                message = fromClient.readLine();
//                outToServer.writeBytes(message + '\n');
//                modmessage = fromServer.readLine();
//                System.out.println("FROM SERVER: " + modmessage);
//                socket.close();
//            } catch (Exception e) {
//                System.out.println("Not connected");
//            }
//        }
//
//
//    }
//}
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String message;
        String modmessage; //this is the joke

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(System.in));
        while (true) {


                Socket socket = new Socket("localhost", 9127);
                DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
                BufferedWriter bufferedWriter = null;
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream())); //why is this not working   what does this do
                message = fromClient.readLine();    //
                outToServer.writeBytes(message + '\n');
                modmessage = fromServer.readLine();
                System.out.println("FROM SERVER: " + modmessage);
                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


        }

    }
}