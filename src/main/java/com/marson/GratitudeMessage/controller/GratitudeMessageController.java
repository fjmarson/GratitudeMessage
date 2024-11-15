package com.marson.GratitudeMessage.controller;

import com.marson.GratitudeMessage.model.GratitudeMessage;
import com.marson.GratitudeMessage.service.GratitudeMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class GratitudeMessageController {

    @Autowired
    private GratitudeMessageService service;

    @PostMapping
    public GratitudeMessage createMessage(@RequestBody GratitudeMessage message) {
        return service.saveMessage(message);
    }

    @GetMapping
    public List<GratitudeMessage> getAllMessages() {
        return service.getAllMessages();
    }

    @GetMapping("/by-date")
    public List<GratitudeMessage> getMessagesByDate() {
        return service.getMessagesByDate();
    }

    @GetMapping("/by-popularity")
    public List<GratitudeMessage> getMessagesByPopularity() {
        return service.getMessagesByPopularity();
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        service.deleteMessage(id);
    }
}
