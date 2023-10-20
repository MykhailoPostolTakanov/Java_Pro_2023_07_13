package clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HeroClientSeconfForMultipleTreading {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String EXIT_COMMAND = "-exit";
    private static final String SEND_MESSAGE_ABOUT_CLOSE_CONNECTING = "Server closed!";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Socket socket = new Socket(SERVER_HOST, SERVER_PORT);

        var out = new PrintWriter(socket.getOutputStream(), true);
        var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("Write command");

        String userInput;
        while ((userInput = scanner.nextLine()) != null) {
            out.println(userInput);
            String messageFromServer = in.readLine();
            if (messageFromServer.equals(EXIT_COMMAND)) {
                System.out.println("Server Answer: " + SEND_MESSAGE_ABOUT_CLOSE_CONNECTING);
                break;
            } else {
                System.out.println("Server Answer: " + messageFromServer);
            }
        }

        out.close();
        in.close();
        socket.close();
    }
}
