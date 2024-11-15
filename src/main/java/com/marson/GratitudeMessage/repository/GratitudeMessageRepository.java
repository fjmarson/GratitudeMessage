package com.marson.GratitudeMessage.repository;

import com.marson.GratitudeMessage.model.GratitudeMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GratitudeMessageRepository extends JpaRepository<GratitudeMessage, Long> {
}
