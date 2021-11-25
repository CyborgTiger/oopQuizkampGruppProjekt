package Server;

import Client.ClientHandler;
import Client.MultiWriter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static MultiWriter multiWriter = new MultiWriter();

    public static void main(String[] args) throws IOException {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(55555);) {
                final Socket socketToClient = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socketToClient, multiWriter);
                clientHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}