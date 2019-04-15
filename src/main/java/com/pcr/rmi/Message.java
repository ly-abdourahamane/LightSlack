package com.pcr.rmi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author abdou on 15/04/19.
 * @project lightslack
 */
@Getter
@Setter
@ToString
public class Message {

    private String value;
    private String sender;

    public Message(String value, String sender) {
        this.value = value;
        this.sender = sender;
    }
}
