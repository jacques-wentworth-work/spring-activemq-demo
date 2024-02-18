package com.example.messageproducer.api;

import com.example.messageproducer.domain.BroadcastMessageResource;
import com.example.messageproducer.domain.MessageResource;
import com.example.messageproducer.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.noContent;

@RestController()
@RequestMapping(value = "/message")
@RequiredArgsConstructor
@Log
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/email/{copies}")
    HttpEntity<?> sendMessage(@RequestBody MessageResource messageResource,
                            @PathVariable int copies) {
        log.info("Received email message request {copies: " + copies + "}:" + messageResource);

        messageService.send(messageResource, copies);
        return noContent().build();
    }

    @PostMapping("/broadcast/{copies}")
    HttpEntity<?> broadcastMessage(@RequestBody BroadcastMessageResource broadcastMessageResource,
                                   @PathVariable int copies) {
        log.info("Received broadcast message:" + broadcastMessageResource);

        messageService.broadcast(broadcastMessageResource, copies);
        return noContent().build();
    }

}
