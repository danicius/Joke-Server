import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
class Server {
    public static void main(String[] args) throws IOException {
//initailzing socket and input streams
        String clientMessage;
        String jokeMessage;
        ServerSocket server = new ServerSocket(9127);

//
//        DataOutputStream dataOutputStream = null;
//        InputStreamReader inputStreamReader;
//        OutputStreamWriter outputStreamWriter;
//        BufferedReader bufferedReader = null;
//        BufferedWriter bufferedWriter;


        while (true) {

            //accepting client in port
            Socket socket = server.accept();
            System.out.println("Hello!");
            System.out.println("Waiting for client command...");
            //create input stream attached to socket
            BufferedReader fromClient = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

            String messageFromClient = " ";
            messageFromClient = fromClient.readLine();

            if (messageFromClient.equals("BYE")) {
                System.out.println("BYEEEE");
                break;
            }

            if (messageFromClient.equals("Joke 1")) {
                String blahBlah = Files.readString(Path.of("joke1.txt"));
                jokeMessage = blahBlah + '\n';
                outToClient.writeBytes(jokeMessage);
                //out.println(jokeMessage);
            }

            if (messageFromClient.equals("Joke 2")) {
                String blahBlah = Files.readString(Path.of("joke2.txt"));
                jokeMessage = blahBlah + '\n';
                outToClient.writeBytes(jokeMessage);
            }

            if (messageFromClient.equals("Joke 3")) {
                String blahBlah = Files.readString(Path.of("joke3.txt"));
                jokeMessage = blahBlah + '\n';
                outToClient.writeBytes(jokeMessage);
            }
          else {
                //System.out.println("ERROR: Not a valid command " + messageFromClient);
                outToClient.writeBytes("ERROR: Not a valid command " + messageFromClient + '\n');

            }
            //System.out.println("Client " + messageFromClient);


        }

    }
}

