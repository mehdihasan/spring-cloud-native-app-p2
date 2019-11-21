package me.mh.configservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@SpringBootApplication
@EnableConfigServer // 2.1
public class ConfigServerGitApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerGitApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	     http
	     // ...
	     .csrf().disable();
	}
}
