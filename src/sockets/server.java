/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.Scanner;
import logic.customer;
   public class server {
    public ServerSocket serverSocket;
    public Socket clientSocket;
    public Scanner scanner;
    public Writer writer;

    public void start(int port) throws IOException, SQLException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        scanner = new Scanner(clientSocket.getInputStream());
        writer = new PrintWriter(clientSocket.getOutputStream(),true);
        
        int choose=scanner.nextInt();
        System.out.println(choose);
        switch (choose) {
            case 1:
                String username=scanner.nextLine(),password=scanner.nextLine();
                customer a=new customer(username,password);
                boolean ret=a.login(a);
                int r=ret?1:0;
                writer.write(r);
                break;

        }
    }

    public void stop() throws IOException {
        scanner.close();
        writer.close();
        clientSocket.close();
        serverSocket.close();
    }
       public static void main(String[] args) throws IOException, SQLException {
           server s=new server();
           s.start(3010);
           clients c=new clients();
           c.startConnection("localhost", 3010);
           c.message(1);
       }
}







/* 
// TODO add your handling code here:
        try {
            serverSocket = new ServerSocket(5678);
            socket = serverSocket.accept();
            setTitle("Connected to "+socket.getInetAddress().getHostAddress()+":"+socket.getPort());
            writer = new PrintWriter(socket.getOutputStream(),true);
            scanner = new Scanner(socket.getInputStream());
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        String input = scanner.nextLine();
                        jTextAreaAllChat.append("Client: "+input+"\n");
                    }
                }
            });
            t.start();
        } catch (Exception e) {
        }
*/
