package com.example.messageproducer.service;

import com.example.messageproducer.domain.BroadcastMessageDto;
import com.example.messageproducer.domain.BroadcastMessageResource;
import com.example.messageproducer.domain.MessageDto;
import com.example.messageproducer.domain.MessageResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Log
public class MessageService {

    private final JmsTemplate jmsTemplate;

    public void send(MessageResource messageResource, int copies) {
        log.info("Sending message: " + messageResource + " copies: (" + copies + ")");
        IntStream.range(1, copies + 1)
                .forEach(copy -> {
                    MessageDto message = new MessageDto(UUID.randomUUID(), messageResource.getSender(), messageResource.getRecipient(), messageResource.getMessage(), copy);
                    log.info("Sending message to Mailbox.QUEUE:" + message);
                    jmsTemplate.convertAndSend("Mailbox.QUEUE", message);
                    log.info("Sent message to Mailbox.QUEUE:" + message);
                });
    }

    public void broadcast(BroadcastMessageResource broadcastMessageResource, int copies) {
        log.info("Sending broadcast message: " + broadcastMessageResource + " copies: (" + copies + ")");
        IntStream.range(1, copies + 1)
                .forEach(copy -> {
                    BroadcastMessageDto broadcastMessageDto = new BroadcastMessageDto(UUID.randomUUID(), broadcastMessageResource.getSender(), broadcastMessageResource.getMessage(), copy);
                    log.info("Sending broadcast message to Broadcast.TOPIC:" + broadcastMessageDto);
                    jmsTemplate.convertAndSend("Broadcast.TOPIC", broadcastMessageDto);
                    log.info("Sent broadcast message to Broadcast.TOPIC:" + broadcastMessageDto);
                });

    }

}
