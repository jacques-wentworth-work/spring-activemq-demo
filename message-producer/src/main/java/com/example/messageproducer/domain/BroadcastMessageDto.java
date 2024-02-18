package com.example.messageproducer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class BroadcastMessageDto {
    UUID guid;
    String sender;
    String message;
    Integer copy;
}
