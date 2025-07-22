package com;
import java.io.*;
import java.net.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private CopyOnWriteArrayList<ClientHandler> clients;
    private String name;

    public ClientHandler(Socket socket, CopyOnWriteArrayList<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Enter your name:");
            name = in.readLine();
            broadcast(name + " joined the chat.");
        } catch (IOException e) {
            closeEverything();
        }
    }

    @Override
    public void run() {
        String msg;
        try {
            while ((msg = in.readLine()) != null) {
                if (msg.equalsIgnoreCase("exit")) {
                    broadcast(name + " left the chat.");
                    break;
                }
                broadcast(name + ": " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeEverything();
        }
    }

    private void broadcast(String msg) {
        for (ClientHandler client : clients) {
            client.out.println(msg);
        }
    }

    private void closeEverything() {
        try {
            clients.remove(this);
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
