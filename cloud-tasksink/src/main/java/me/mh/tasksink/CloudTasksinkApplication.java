package me.mh.tasksink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher // 5.2
public class CloudTasksinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudTasksinkApplication.class, args);
	}

}
