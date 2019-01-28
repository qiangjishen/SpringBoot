package cn.cnnic.sprngBoot2Famework.trip.service;

import java.util.List;

import cn.cnnic.sprngBoot2Famework.home.vo.TripLine;
import cn.cnnic.sprngBoot2Famework.trip.vo.Trip;

public interface TripService {

	public List<Trip> getTripByType(int type);
	
	public List<TripLine> getTripLine();
}
