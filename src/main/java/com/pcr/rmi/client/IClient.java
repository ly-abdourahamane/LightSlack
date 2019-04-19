package com.pcr.rmi.client;

import com.pcr.rmi.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author abdou on 15/04/19.
 * @project lightslack
 */
public interface IClient extends Remote {

    void send(Message message) throws RemoteException;
}
