package com.tsys.virtualizer;

import org.apache.cxf.spring.boot.autoconfigure.CxfAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = CxfAutoConfiguration.class)
public class VirtualizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualizerApplication.class, args);
	}

}
