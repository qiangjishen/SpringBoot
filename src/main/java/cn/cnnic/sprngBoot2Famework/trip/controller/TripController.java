package cn.cnnic.sprngBoot2Famework.trip.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cnnic.sprngBoot2Famework.trip.service.TripService;
import cn.cnnic.sprngBoot2Famework.trip.vo.Trip;

/**
 * 发主发布的路线模块
 * 
 * @author qiangjishen
 *
 */
@Controller
@RequestMapping("/trip")
public class TripController {
	
	private final Log logger = LogFactory.getLog(TripController.class);


	@Autowired
	TripService tripService;
	
	/**
	 * 获取所有车主发布的拼车信息
	 * @param date   出行时间
	 * @param line   路线
	 * @return
	 */
	@RequestMapping(value = "/getTripInfo")
	public String getAllInfo(String date, int line, ModelMap map) {
		List<Trip> list = new ArrayList<Trip>();
		
		list = tripService.getTripByType(1);
			
			map.put("list", list);

		
		return "/trip";
	}
}
