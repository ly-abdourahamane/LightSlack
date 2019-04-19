package com.pcr.rmi;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author abdou on 15/04/19.
 * @project lightslack
 */
@Getter
@Setter
public class Message implements Serializable {

    private String value;
    private String sender;

    public Message(String value, String sender) {
        this.value = value;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "[" + sender + "] " + value;
    }
}
