package com.example.messageproducer.domain;

import lombok.Data;

@Data
public class BroadcastMessageResource {
    String sender;
    String message;
}
