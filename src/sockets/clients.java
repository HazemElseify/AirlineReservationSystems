
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
    public PrintWriter writer;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        scanner = new Scanner(clientSocket.getInputStream());
        writer = new PrintWriter(clientSocket.getOutputStream(),true);
    }
    public void message(int msg) throws IOException{
       Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    writer.println(msg);
                }
            });
            t.start();
    }
     public void message(String msg) throws IOException{
       Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    writer.println(msg);
                }
            });
            t.start();
    }
    public void stopConnection() throws IOException {
        scanner.close();
        writer.close();
        clientSocket.close();
    }
    public static void main(String[] args) throws IOException {
           clients c=new clients();
           c.startConnection("localhost", 3010);
    }
}
