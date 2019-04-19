package com.pcr.rmi.client;

import com.pcr.rmi.Message;
import com.pcr.rmi.server.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author abdou on 15/04/19.
 * @project lightslack
 */
public class Client implements IClient {

    private IServer server;

    public void connect() throws MalformedURLException, RemoteException, NotBoundException {
        server = (IServer) Naming.lookup("localhost/server");
    }

    //TODO: Utiliser plutard
    public void update() throws RemoteException{
        List<Message> messages = server.getMessages();
        messages.forEach(message -> {
            System.out.println(message);
        });
    }

    public static void  main(String...args) {
        Client client = new Client();
        String name = UUID.randomUUID().toString();
        try {
            client.connect();
            Scanner scanner = new Scanner(System.in);
            while(true){
                String text = scanner.nextLine();
                client.send(new Message(text, name));
            }
        } catch (MalformedURLException | RemoteException | NotBoundException  e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(Message message) throws RemoteException {
        server.receive(message);
    }
}
