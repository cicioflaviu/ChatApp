package main.java.fcicio.chatapp.messageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MessageserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageserviceApplication.class, args);
	}
}
