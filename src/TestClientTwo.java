import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TestClientTwo {

    static PrintWriter out;

    public static void main(String[] args) throws IOException {


        System.out.println("Hello ! What server would you like to connect too? (Press ENTER for localhost)...");

        String host = "localhost";
        int port = 5000;

        Scanner input = new Scanner(System.in);

        try {
            Socket socket = new Socket(host,port);

            Scanner instream = new Scanner(socket.getInputStream());
            PrintWriter outstream = new PrintWriter(socket.getOutputStream());

            new Thread (() -> {

                while (true) {
                    System.out.println(instream.nextLine());
                }
            }).start();

            while (true) {

                outstream.println(input.nextLine());
                outstream.flush();
            }

        } catch (IOException exception) {

            exception.printStackTrace();

        }

    }


      /*  System.out.println("Hello ! What server would you like to connect too? (Press ENTER for localhost)...");
        Scanner scanner = new Scanner(System.in);
        String serverString = scanner.nextLine();
        if (serverString.equals("")) {
            serverString = "localhost";
        }

        System.out.println("Connecting to " + serverString);
        var socket = new Socket(serverString, 59002);
        Scanner in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);

        while (in.hasNextLine()) {
            var line = in.nextLine();
            if (line.startsWith("SUBMITNAME")) {
                System.out.println("Enter your name: ");
                String mitNavn = scanner.nextLine();
                out.println(mitNavn);
            } else if (line.startsWith("NAMEACCEPTED")) {
                System.out.println("Chatting - " + line.substring(13));
                sendMessage();
            } else if (line.startsWith("MESSAGE")) {
                System.out.println(line.substring(8) + "\n");
                sendMessage();
            }

        }

    }

    public static void sendMessage() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Write a message:");
            String besked = scanner.nextLine();
            out.println(besked);

    }
*/

}
