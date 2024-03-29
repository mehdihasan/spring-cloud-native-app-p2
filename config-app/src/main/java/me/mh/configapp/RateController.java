package me.mh.configapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 3.3 - set up the controller and the html template
@Controller
@RefreshScope // 3.4.2 - added refresh scope
public class RateController {
	
	@Value("${rate}")
	String rate;
	
	@Value("${lanecount}")
	String laneCount;
	
	@Value("${tollstart}")
	String tollStart;
	
	@Value("${connstring}")
	String connString;
	
	
	@RequestMapping("/rate")
	public String getRate(Model model) {
		
		model.addAttribute("rateamount", rate);
		model.addAttribute("lanes", laneCount);
		model.addAttribute("tollstart", tollStart);
		model.addAttribute("connstring", connString);
		
		return "rateview";
	}

}
