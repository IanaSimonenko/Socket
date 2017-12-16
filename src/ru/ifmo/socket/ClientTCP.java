package ru.ifmo.socket;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientTCP {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 1500);
            ObjectInputStream in = new
                    ObjectInputStream(clientSocket.getInputStream());

            DateMessage dateMessage =
                    (DateMessage) in.readObject();

            System.out.println(dateMessage.getMessage());
            System.out.println(dateMessage.getDate());
        }  catch (Exception e) {
            e.printStackTrace();
        }

    }

}