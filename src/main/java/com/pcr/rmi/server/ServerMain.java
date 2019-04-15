package com.pcr.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * @author abdou on 15/04/19.
 * @project lightslack
 */
public class ServerMain {

    public static void main(String[] args) {
        try {
            Server server = new Server();
            Naming.rebind("rmi://localhost/Server", server);
            System.out.println("Server start");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
