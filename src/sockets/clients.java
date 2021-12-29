
package sockets;

import gui.Home;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clients {
    public Socket clientSocket;
    public Scanner scanner;
    public Writer writer;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        scanner = new Scanner(clientSocket.getInputStream());
        writer = new PrintWriter(clientSocket.getOutputStream(),true);
    }
    public void message(int msg) throws IOException{
        Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        writer.write(msg);
                    } catch (IOException ex) {
                        Logger.getLogger(clients.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            t.start();
    }
     public void message(String msg) throws IOException{
       Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        writer.write(msg);
                    } catch (IOException ex) {
                        Logger.getLogger(clients.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            t.start();
    }
    public void stopConnection() throws IOException {
        scanner.close();
        writer.close();
        clientSocket.close();
    }
}
