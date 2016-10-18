package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan

public class MainServer {

	public static void main(String[] args) {
		SpringApplication.run(MainServer.class, args);
	}

}
