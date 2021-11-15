package Server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    String output = "hejsan";


    public Server() {
        int portNumber = 12345;

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
        ) {

            while (true) {
                out.println(output);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }

}