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
    public PrintWriter writer;

    public void start(int port) throws IOException, SQLException {
        System.out.println("1");
        serverSocket = new ServerSocket(port);
          System.out.println("1");
        clientSocket = serverSocket.accept();
          System.out.println("1");
        scanner = new Scanner(clientSocket.getInputStream());
          System.out.println("1");
        writer = new PrintWriter(clientSocket.getOutputStream(),true);
        System.out.println("1");

        int choose=scanner.nextInt();
        System.out.println(choose);
        switch (choose) {
            case 1:
                String username=scanner.nextLine();
                System.out.println(username);
                String password=scanner.nextLine();
                System.out.println(password);
                customer a=new customer(username,password);
                boolean ret=a.login(a);
                int r=ret?1:0;
                System.out.println(r);
                writer.print(r);
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
