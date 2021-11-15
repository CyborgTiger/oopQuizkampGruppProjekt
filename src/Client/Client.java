package Client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    Client() {
        String hostName = "127.0.0.1";
        int portNumber = 44444;

        try (
                Socket Socket = new Socket(hostName, portNumber);
                PrintWriter toServer = new PrintWriter(Socket.getOutputStream(), true);
                BufferedReader serverIn = new BufferedReader(
                        new InputStreamReader(Socket.getInputStream()));
                BufferedReader clientInput =
                        new BufferedReader(new InputStreamReader(System.in))
        ) {


            String fromServer;
            String fromUser;

            while ((fromServer = serverIn.readLine()) != null) {
                String question = "Where are tigers from? A: Africa B: Asia C: Europe D: South America";
                System.out.println("Server: " + fromServer);
                if (!fromServer.equals(question)){
                    toServer.println("");
                    continue;
                }
                fromUser = clientInput.readLine();
                if (fromUser != null) {
                    toServer.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        new Client();
    }
}
