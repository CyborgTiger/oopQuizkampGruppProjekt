package Client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread{
    public String fromUser = "";

    Client() {
        start();
    }
    public void answerChoice(int answerNumber){
        if (answerNumber == 0){
            action("1");
        } else if (answerNumber == 1){
            action("2");
        } else if (answerNumber == 2){
            action("3");
        } else if (answerNumber == 3){
            action("4");
        }
    }
    public void signUpChoice(){
        action("sign up");
    }

    public void action(String actionChoice){
        fromUser = actionChoice;
    }
    @Override
    public void run() {
        String hostName = "127.0.0.1";
        int portNumber = 44444;

        try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in))
        ) {


            String fromServer;

            while ((fromServer = serverIn.readLine()) != null) {
                if (fromServer.equals("Correct") || fromServer.equals("Incorrect")){
                    toServer.println("");
                    continue;
                }
                if (fromUser.equals("")) {
                    toServer.println(fromUser);
                    fromUser = "";
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
}
