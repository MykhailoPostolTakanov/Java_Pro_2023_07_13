package clientserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = null;

            while (true) {
                System.out.println("Waiting for connecting...");
                socket = serverSocket.accept();
                System.out.println("Connecting success...");
                new EchoMultipleThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
