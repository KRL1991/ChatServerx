import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestConnectionClientToPI {




    public static void main(String[] args) throws IOException {

        String host = "10.200.130.31";
        int port = 4501;
        String temp;
        String humd;

        Scanner inputScanner = new Scanner(System.in);

        try {
            Socket socket = new Socket(host, port);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());




            new Thread(() -> {

                while (true) {
                    DataInputStream inputStream;


                    try {
                        inputStream = new DataInputStream(socket.getInputStream());

                       // if (inputStream.readUTF().contains("C")) {

                           // temp =  inputStream.readUTF();

                            System.out.println(inputStream.readUTF());
                       // }

                       // if (inputStream.readUTF().contains("%")) {
                            System.out.println(inputStream.readUTF());
                       // }



                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }).start();


        } catch (Exception exception) {
        }


    }

}
