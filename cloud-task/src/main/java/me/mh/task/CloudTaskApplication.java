package me.mh.task;

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
	
	// 4.3
	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}
	

	/**
	 * 4.2
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
					
					String stationId = args[0];
					String licensePlateNumber = args[1];
					String timeStamp = args[2];
					
					System.out.println("station ID: " + stationId);
					System.out.println("license plate: " + licensePlateNumber);
					System.out.println("timestamp: " + timeStamp);	
				}
			}
		}
		
	}
}
