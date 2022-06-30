package com.tbannaarr.com.clr.roomclr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RoomClrApplication {
	private static final Logger LOG = LoggerFactory.getLogger(RoomClrApplication.class);
	//since we're running spring web here is the reason, we gonna create a rest template
	//What we get autoConfigure is a RestTemplate Builder.
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	//although separate class for this
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		//lambda
		return ars -> {
			//knowing that it starts
			LOG.info("Starting CLR application");
			//construct -> a Templatized Construct - call rest template, exchange n get element back
			ResponseEntity<List<Room>> rooms = restTemplate.exchange("http://localhost:8080/api/rooms",
					HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
					});
			//as it returns the room list, we loop
			rooms.getBody().forEach(room -> {
				LOG.info(room.toString());
			});
			//knowing when it ends
			LOG.info("Finishing CLR application");
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(RoomClrApplication.class, args);
	}

}
