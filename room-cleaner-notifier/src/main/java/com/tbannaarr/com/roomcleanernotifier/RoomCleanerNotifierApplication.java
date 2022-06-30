package com.tbannaarr.com.roomcleanernotifier;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RoomCleanerNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomCleanerNotifierApplication.class, args);
	}

	private static final String QUEUE_NAME = "room-cleaner";
	private static final String EXCHANGE_NAME = "operations";

	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	public TopicExchange exchange(){
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with("landon.rooms.cleaner");
	}


//	@Bean
//	public Connection connectionFactory(){
//		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("127.0.0.1");
//		//connectionFactory.setUri("amqp://guest@127.0.0.1:5672/");
//		//connectionFactory.setPort(5762);
//		connectionFactory.setUsername("guest");
//		connectionFactory.setPassword("guest");
//
////		connectionFactory.setVirtualHost("/");
//
//		return connectionFactory.createConnection();
//	}

}
