package cn.cnnic.sprngBoot2Famework.home.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cnnic.sprngBoot2Famework.home.vo.HomeVo;
import cn.cnnic.sprngBoot2Famework.home.vo.TripLine;
import cn.cnnic.sprngBoot2Famework.trip.service.TripService;
import cn.cnnic.sprngBoot2Famework.util.DateUtil;

/**
 * 
 * 
 * @author qiangjishen
 *
 */
@Controller
@RequestMapping("/home")
public class HomeController {

	private final Log logger = LogFactory.getLog(HomeController.class);
	
	@Autowired
	private TripService tripService;
	
	@RequestMapping(value = "/getHome")
	public String getAllInfo( ModelMap map) {
		String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		
		List<HomeVo> dateList = new ArrayList<HomeVo>();
		Date currDate = Calendar.getInstance().getTime();
		

		for(int i=0; i<=5; i++) {
			
			HomeVo vo = new HomeVo();
			Date sd = new Date(currDate.getTime()+(1000*3600*24)*i);
			Calendar cal = Calendar.getInstance();
			cal.setTime(sd);
			
			int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
			String dates = DateUtil.format(sd, "MM-dd");

			vo.setDay(dates);
			vo.setWeek(weekDays[w]);
			
			dateList.add(vo);
		}
		
		List<TripLine> lineList = tripService.getTripLine();

		
		map.put("dateList", dateList);
		map.put("lineList", lineList);
		
		return "main";
	}
}
