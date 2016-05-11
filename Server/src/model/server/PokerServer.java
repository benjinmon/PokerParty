package model.server;

/**
 * Created by Matthias Walk on 24.02.2016.
 * Class of the project: PokerParty
 * TODO: Get the Server Running, make it accessible for multible users.
 */

import java.net.*;
import java.io.*;

public class PokerServer {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Missing Port in Programm arguments.");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                new PokerServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}