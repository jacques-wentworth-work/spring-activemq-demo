package com.example.messageproducer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BroadcastMessageDto {
    UUID guid;
    String sender;
    String message;
    Integer copy;
}
