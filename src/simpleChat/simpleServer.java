package simpleChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class simpleServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started...");

        while (true) {

            Socket socket = serverSocket.accept();
            System.out.println("Connection established !");

            ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputFromClient = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                Message readFromClient = (Message) inputFromClient.readObject();
                System.out.println("Recieved: "+ readFromClient);

                if (readFromClient.getMessage().equalsIgnoreCase("exit")) {
                    break;

                }

                String result = readFromClient.getMessage().toUpperCase();
                outputFromClient.writeObject(new Message(result));
            }
        }
    }



}
