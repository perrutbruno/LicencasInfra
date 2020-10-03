package br.com.alterdata.notafiscalms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NotafiscalMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotafiscalMsApplication.class, args);
	}

}
