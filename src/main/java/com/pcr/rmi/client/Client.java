package com.pcr.rmi.client;

import com.pcr.rmi.Message;
import com.pcr.rmi.server.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author abdou on 15/04/19.
 * @project lightslack
 */
public class Client {

    private IServer server;

    public void connect() throws MalformedURLException, RemoteException, NotBoundException {
        server = (IServer) Naming.lookup("rmi://localhost/Server");
    }

    public void update() throws RemoteException{
        List<Message> messages = server.getMessages();
        messages.forEach(message -> {
            System.out.println(message);
        });
    }

    public void send(Message m) throws RemoteException {
        server.receive(m);
    }
}
