/**
 * The main class for the Notification Service application.
 * This class is responsible for handling Kafka events related to order notifications.
 *
 * The application listens to the "notificationTopic" Kafka topic and handles
 * OrderPlacedEvent events by logging the order number.
 *
 * To run the application, use the main method and pass any required arguments.
 */
package com.java.notificationservice;

import com.java.notificationservice.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotificationEvent(OrderPlacedEvent orderPlacedEvent){
        log.info("Received Notification for order - {}",orderPlacedEvent.getOrderNumber());
    }
}
