package simpleChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("localhost",5000);

        ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputToServer = new ObjectInputStream(socket.getInputStream());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();

            String data = "Hello again";
            System.out.println("Sending: " + userInput);
            outputToServer.writeObject(new Message(userInput));

            if (userInput.equalsIgnoreCase("exit")) {

                socket.close();
                break;

            }


            Message result = (Message) inputToServer.readObject();
            System.out.println(result.getMessage());
        }
    }
}
