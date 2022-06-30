package com.tbannaarr.com.roomcleanernotifier;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

//@PropertySource(value = "classpath:application.properties")
@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    private ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        int index = (int) ((Math.random())*(9-1)) + 1;//9 rows in ds db
        AsyncPayload payload = new AsyncPayload();
        payload.setId(index);
        payload.setModel("ROOM");
        rabbitTemplate.convertAndSend("operations", "landon.rooms.cleaner",
                objectMapper.writeValueAsString(payload));
        context.close();
        //shutdown d app context when done. Gr8 way 4 rabbit
    }

//    @Override
//    public void run(String... args) throws Exception {
//        int index = (int) ((Math.random())*(9-1)) + 1;//9 rows in ds db
//        AsyncPayload payload = new AsyncPayload();
//        payload.setId(index);
//        payload.setModel("ROOM");
//        rabbitTemplate.convertAndSend("operations", "landon.rooms.cleaner",
//                objectMapper.writeValueAsString(payload));
//        context.close();
//        //shutdown d app context when done. Gr8 way 4 rabbit
//    }
}
