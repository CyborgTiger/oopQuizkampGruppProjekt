package Client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    String output = "Meddelande";

    Client() throws IOException {
        String hostName = "127.0.0.1";
        int portNumber = 12345;


        try (
                Socket adressSocket = new Socket(hostName, portNumber);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(adressSocket.getInputStream())
                )
        ) {
            String fromServer;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server : " + fromServer);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldnt get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
    public static void main(String[] args) throws IOException {
        Client c = new Client();
    }
}
