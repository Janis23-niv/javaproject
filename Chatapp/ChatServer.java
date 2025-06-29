import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Chat Server started on port 1234...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected.");

            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clients.add(clientHandler);
            new Thread(clientHandler).start();
        }
    }

    static void broadcast(String message, ClientHandler excludeUser) {
        for (ClientHandler client : clients) {
            if (client != excludeUser) {
                client.sendMessage(message);
            }
        }
    }

    static void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Error setting up client I/O.");
            }
        }

        public void run() {
            try {
                // Send username prompt immediately after connection
                out.println("Enter your username:");
                username = in.readLine();

                if (username == null || username.trim().isEmpty()) {
                    out.println("Invalid username. Connection closing.");
                    socket.close();
                    return;
                }

                System.out.println(username + " has joined the chat.");
                out.println("Welcome to the chat, " + username + "!");
                broadcast(username + " has joined the chat.", this);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(username + ": " + message);
                    broadcast(username + ": " + message, this);
                }
            } catch (IOException e) {
                System.out.println(username + " disconnected.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                removeClient(this);
                if (username == null || username.trim().length() == 0) {
                    
                }
                else{
                    broadcast(username + " has left the chat.", this);
                    System.out.println(username + " has left the chat.");
                }
            }
        }

        void sendMessage(String message) {
            out.println(message);
        }
    }
}
