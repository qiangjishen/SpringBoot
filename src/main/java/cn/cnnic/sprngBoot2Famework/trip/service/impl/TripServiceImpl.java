package cn.cnnic.sprngBoot2Famework.trip.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cnnic.sprngBoot2Famework.home.vo.TripLine;
import cn.cnnic.sprngBoot2Famework.mapper.TripLineMapper;
import cn.cnnic.sprngBoot2Famework.mapper.TripMapper;
import cn.cnnic.sprngBoot2Famework.trip.service.TripService;
import cn.cnnic.sprngBoot2Famework.trip.vo.Trip;


@Service
public class TripServiceImpl  implements TripService{

	@Autowired
	private TripMapper tripMapper;
	
	@Autowired
	private TripLineMapper tripLineMapper;

	@Override
	public List<Trip> getTripByType(int type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tripType", type);
		
		List<Trip> list = tripMapper.getTripListByType(params);
		
		return list;
	}

	@Override
	public List<TripLine> getTripLine() {
		Map<String, Object> map = new HashMap<String, Object>();
		return tripLineMapper.getList(map);
	}
}
