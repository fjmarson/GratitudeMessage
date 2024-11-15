package com.marson.GratitudeMessage.service;

import com.marson.GratitudeMessage.model.GratitudeMessage;
import com.marson.GratitudeMessage.repository.GratitudeMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GratitudeMessageService {
    @Autowired
    private GratitudeMessageRepository repository;

    public GratitudeMessage saveMessage(GratitudeMessage message) {
        message.setDate(LocalDateTime.now());
        return repository.save(message);
    }

    public List<GratitudeMessage> getAllMessages() {
        return repository.findAll();
    }

    public List<GratitudeMessage> getMessagesByDate() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    public List<GratitudeMessage> getMessagesByPopularity() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "popularity"));
    }

    public void deleteMessage(Long id) {
        repository.deleteById(id);
    }
}
