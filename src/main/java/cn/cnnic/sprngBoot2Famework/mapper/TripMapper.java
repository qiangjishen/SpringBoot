package cn.cnnic.sprngBoot2Famework.mapper;

import java.util.List;
import java.util.Map;

import cn.cnnic.sprngBoot2Famework.trip.vo.Trip;

public interface TripMapper {
    int deleteByPrimaryKey(Integer tripId);

    int insert(Trip record);

    int insertSelective(Trip record);

    Trip selectByPrimaryKey(Integer tripId);

    int updateByPrimaryKeySelective(Trip record);

    int updateByPrimaryKey(Trip record);
    
    List<Trip> getTripListByType(Map<String, Object> params);
}