package com.example.messagelreceiver.listener;


import com.example.messageproducer.domain.BroadcastMessageDto;
import com.example.messageproducer.domain.MessageDto;
import lombok.extern.java.Log;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class MessageConsumer {

    @JmsListener(destination = "Mailbox.QUEUE", containerFactory = "queueConnectionFactory")
    public void messageReceiver(MessageDto messageDto) {
        log.info("Message received <" + messageDto + ">");
    }

    @JmsListener(destination = "Broadcast.TOPIC", containerFactory = "topicConnectionFactory")
    public void broadcastMessageReceiver(BroadcastMessageDto broadcastMessageDto) {
        log.info("Broadcast message received <" + broadcastMessageDto + ">");
    }

}
