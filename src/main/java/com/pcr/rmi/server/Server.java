package com.pcr.rmi.server;

import com.pcr.rmi.Message;

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

    protected Server() throws RemoteException {
        super();
        messages = new ArrayList<>();
    }

    @Override
    public void receive(Message message) throws RemoteException {
        messages.add(message);
    }

    @Override
    public List<Message> getMessages() throws RemoteException {
        return messages;
    }
}
