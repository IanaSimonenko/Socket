package ru.ifmo.socket;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class ServerTCP extends Thread {

    ServerSocket serverSocket = null;

    public ServerTCP() {
        try {
            serverSocket = new ServerSocket(1500);
            System.out.println("Starting the server ");
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection accepted from "
                        + clientSocket.getInetAddress().getHostAddress());

                ObjectOutputStream out =
                        new ObjectOutputStream(
                                clientSocket.getOutputStream());

                DateMessage dateMessage = new DateMessage(
                        Calendar.getInstance().getTime(),
                        "Текущая дата/время на сервере");
                out.writeObject(dateMessage);
                out.close();
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        new ServerTCP();
    }

}
