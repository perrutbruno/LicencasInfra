package br.com.alterdata.licenciamentoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LicenciamentoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicenciamentoMsApplication.class, args);
	}

}
