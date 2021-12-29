/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import database.database;
import static gui.Customer.customerreserve.userName;
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import logic.Admin;
import logic.AirPlane;
import logic.customer;

public class server {

    public ServerSocket serverSocket;
    public Socket clientSocket;
    public Scanner scanner;
    public PrintWriter writer;

    public void start(int port) throws IOException, SQLException, ClassNotFoundException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        while (true) {
        scanner = new Scanner(clientSocket.getInputStream());
        writer = new PrintWriter(clientSocket.getOutputStream(), true);
            String choose = scanner.nextLine();
            int ch = Integer.parseInt(choose);
            if (ch == 1) {
                String username = scanner.nextLine(), password = scanner.nextLine();
                customer a = new customer(username, password);
                boolean ret = a.login(a);
                int r = ret ? 1 : 0;
                writer.println(String.valueOf(r));
            } else if (ch == 2) {
                String username = scanner.nextLine(), password = scanner.nextLine();
                Admin a = new Admin(username, password);
                boolean ret = a.login(a);
                int r = ret ? 1 : 0;
                writer.println(String.valueOf(r));
            } else if (ch == 3) {
                ArrayList<AirPlane> arrayList;
                String ok1 = scanner.nextLine();
                arrayList = database.date_plane(ok1);
                writer.println(String.valueOf(arrayList.size()));
                for (int i = 0; i < arrayList.size(); ++i) {
                    writer.println(arrayList.get(i).getPlaneId());
                    writer.println(arrayList.get(i).getPlaneDate());
                }
            } else if (ch == 4) {
                ArrayList<String> arrayList;
                arrayList = database.getSeatslist(scanner.nextLine());
                writer.println(String.valueOf(arrayList.size()));
                for (int i = 0; i < arrayList.size(); ++i) {
                    writer.println(arrayList.get(i));
                }
            } else if (ch == 5) {
                String username = scanner.nextLine();
                int size = Integer.parseInt(scanner.nextLine());
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < size; ++i) {
                    arrayList.add(scanner.nextLine());
                }
                
               if(database.updateAll(username, arrayList)){
                   writer.println("1");
               }
               else {
                   writer.println("0");
               }
            } else if (ch == 6) {
                customer ID = new customer();
                ID.setUsernmae(scanner.nextLine());
                ArrayList<AirPlane> planedata = new ArrayList<AirPlane>();
                planedata = database.planeid_Customer(ID);
                writer.println(String.valueOf(planedata.size()));
                for(int i=0;i<planedata.size();++i){
                    writer.println(planedata.get(i).getPlaneId());
                    writer.println(planedata.get(i).getPlaneDistination());
                    writer.println(planedata.get(i).getPlaneDate());
                    writer.println(planedata.get(i).getSeatNum());
                }
            }
        }
    }

    public void stop() throws IOException {
        scanner.close();
        writer.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        server s = new server();
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
