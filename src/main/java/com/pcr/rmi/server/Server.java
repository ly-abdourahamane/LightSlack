package com.pcr.rmi.server;

import com.pcr.rmi.Message;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdou on 15/04/19.
 * @project lightslack
 */
public class Server extends UnicastRemoteObject implements IServer {

    private List<Message> messages;

    Server() throws RemoteException {
        messages = new ArrayList<>();
    }

    @Override
    public void receive(Message message) throws RemoteException {
        System.out.println(message);
        messages.add(message);
    }

    @Override
    public List<Message> getMessages() throws RemoteException {
        return messages;
    }

    public static void main(String[] args) {
        try {
            IServer server = new Server();
            Naming.rebind("localhost/server", server);
            System.out.println("Server start");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
