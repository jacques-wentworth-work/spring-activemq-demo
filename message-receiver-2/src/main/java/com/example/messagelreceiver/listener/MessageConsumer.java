package com.example.messagelreceiver.listener;


import com.example.messageproducer.domain.BroadcastMessageDto;
import lombok.extern.java.Log;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class MessageConsumer {

    @JmsListener(destination = "Broadcast.TOPIC", containerFactory = "topicConnectionFactory")
    public void broadcastMessageReceiver(BroadcastMessageDto broadcastMessageDto) {
        log.info("Broadcast message received <" + broadcastMessageDto + ">");
    }

}
