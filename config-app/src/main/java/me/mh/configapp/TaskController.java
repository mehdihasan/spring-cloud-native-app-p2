package me.mh.configapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// 6.3
@RestController
public class TaskController {

	@Autowired
	private Taskprocessor taskprocessor;
	
	@RequestMapping(path = "/tasks", method = RequestMethod.POST)
	public @ResponseBody String launchTask(@RequestBody String input) {
		taskprocessor.publishRequest(input, "config-app");
		System.out.println("requst made");
		return "Success";
	}
}
