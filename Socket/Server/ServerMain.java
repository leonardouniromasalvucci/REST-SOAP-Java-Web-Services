/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leona
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerMain {

    public static void main(String[] args) {

        List<ClientThread> ctList = new ArrayList<ClientThread>();
        ServerSocket lis = null;

        try {
            lis = new ServerSocket(8080);
        } catch (IOException e1) {
            System.out.println("Errore nella creazione del ServerSocket, applicazione dismessa");
            System.exit(1);
        }
        System.out.println("Server avviato");
        Socket sock = null;

        while (true) {
            try {
                sock = lis.accept();
            } catch (IOException e) {
                break;
            }
            System.out.println("Socket creata, connessione accettata");
            ClientThread cl = new ClientThread(sock);
            Thread tr = new Thread(cl);
            tr.start();
            ctList.add(cl);
        }
    }

}

