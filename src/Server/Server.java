package Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public Server() {

        int portNumber = 44445;

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String inputLine, outputLine;

            out.println(sendQuestion());

            while ((inputLine = in.readLine()) != null) {

                outputLine = inputLine;
                if (outputLine.equals("Bye.")){
                    break;
                } else if (outputLine.equals("B")){
                    out.println("Correct");
                    out.println(sendQuestion());
                } else{
                    out.println("Incorrect");
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen "
                    + "on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Server();
    }

    private String sendQuestion(){
        String output;
        output = "Where are tigers from? A: Africa B: Asia C: Europe D: South America";
        return output;
    }
}