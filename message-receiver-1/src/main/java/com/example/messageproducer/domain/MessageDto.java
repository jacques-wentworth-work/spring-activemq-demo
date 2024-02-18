package com.example.messageproducer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    UUID guid;
    String sender;
    String recipient;
    String message;
    Integer copy;
}
