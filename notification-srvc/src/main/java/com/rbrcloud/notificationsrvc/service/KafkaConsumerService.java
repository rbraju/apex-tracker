package com.rbrcloud.notificationsrvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.rbrcloud.shared.constants.KafkaTopics.PORTFOLIO_UPDATE;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = PORTFOLIO_UPDATE, groupId = "notification-group")
    public void consume(String message) {
        logger.info("Received message for notification : {}", message);
    }
}
