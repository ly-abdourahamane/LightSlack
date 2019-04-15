package com.pcr.rmi.server;

import com.pcr.rmi.Message;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author abdou on 15/04/19.
 * @project lightslack
 */
public interface IServer {

    void receive(Message message) throws RemoteException;
    List<Message> getMessages() throws RemoteException;
}
