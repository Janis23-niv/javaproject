import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read username prompt from server and display it
            String prompt = in.readLine();
            System.out.print(prompt + " ");  // e.g. "Enter your username: "
            String username = console.readLine();
            out.println(username);  // send username

            // Read welcome message from server
            String welcome = in.readLine();
            System.out.println(welcome);

            // Thread to listen for messages from server
            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            }).start();

            // Main thread sends user input messages to server
            String input;
            while ((input = console.readLine()) != null) {
                out.println(input);
            }

        } catch (IOException e) {
            System.out.println("Could not connect to server: " + e.getMessage());
        }
    }
}
