package com.rbrcloud.notificationsrvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class NotificationSrvcApplication {
    public static void main(String[] args) {
        System.out.println(">>> CHECKING IF REBUILD WORKED <<<");
        SpringApplication.run(NotificationSrvcApplication.class, args);
    }
}
