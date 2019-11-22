package me.mh.configapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

// 6.1
@Component
@EnableBinding(Source.class)
public class Taskprocessor {

	// @Value("${}")
	
	// this is the rabbitmq item
	@Autowired
	private Source source;
	
	
	/**
	 * this is the method which is publishing message to the queue
	 * @param payload
	 */
	public void publishRequest(String payload, String applicationName) {
		
		// TODO: get the value from the config server
		String url = "maven://me.mh:cloud-task:jar:0.0.1-SNAPSHOT";
		
		List<String> input = new ArrayList<String>(Arrays.asList(payload.split(",")));
		
		TaskLaunchRequest taskRequest = new TaskLaunchRequest(url, input, null, null, applicationName);
		
		System.out.println("Created task request");
		
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<TaskLaunchRequest>(taskRequest);
		
		this.source.output().send(message);
	}
}
