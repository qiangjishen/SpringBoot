package cn.cnnic.sprngBoot2Famework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


	/**
	 * 注释
	 * @return
	 */
	@RequestMapping(value = "/getUser")
	public List<String> getUser(){
		List<String> list = new ArrayList<String>();
		list.add("perter");
		
		return list;
	}
}
