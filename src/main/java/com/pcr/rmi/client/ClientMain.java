package com.pcr.rmi.client;

import com.pcr.rmi.Message;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @author abdou on 15/04/19.
 * @project lightslack
 */
public class ClientMain {

    public static void  main(String...arStrings) {
        Client client = new Client();
        try {
            client.connect();
            Scanner scanner = new Scanner(System.in);
            while(true){
                String r = scanner.nextLine();
                if(r.equals("update")){
                    client.update();
                }else {
                    client.send(new Message(r, arStrings[1]));
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
