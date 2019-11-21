package me.mh.configapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask // 4.1
@SpringBootApplication
public class CloudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudTaskApplication.class, args);
	}
	
	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}
	

	/**
	 * 
	 * @author admin
	 * need to implement CommandLineRunner or ApplicationRunner
	 * here we are implementing CommandLineRunner
	 */
	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			// parameters stationid, license plate, timestamp
			if (null != args) {
				System.out.println("total item: " + args.length);
				if (args.length >= 3) {
					System.out.println("station ID: " + args[0]);
					System.out.println("license plate: " + args[1]);
					System.out.println("timestamp: " + args[2]);	
				}
			}
		}
		
	}
}
