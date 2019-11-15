package me.mh.configservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // 2.1
public class ConfigServerGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerGitApplication.class, args);
	}

}
