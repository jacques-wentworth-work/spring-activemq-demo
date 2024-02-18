package com.example.messageproducer.domain;

import lombok.Data;

@Data
public class MessageResource {
    String sender;
    String recipient;
    String message;
}
