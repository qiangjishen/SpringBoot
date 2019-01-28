package cn.cnnic.sprngBoot2Famework.mapper;

import java.util.List;
import java.util.Map;

import cn.cnnic.sprngBoot2Famework.home.vo.TripLine;

public interface TripLineMapper {
    int deleteByPrimaryKey(Integer lineId);

    int insert(TripLine record);

    int insertSelective(TripLine record);

    TripLine selectByPrimaryKey(Integer lineId);

    int updateByPrimaryKeySelective(TripLine record);

    int updateByPrimaryKey(TripLine record);
    
    List<TripLine> getList(Map<String ,Object> map);
}