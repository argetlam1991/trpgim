package com.trpgim.trpgim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.trpgim.trpgim","com.trpgim.game"})
public class TrpgimApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrpgimApplication.class, args);
	}
}
