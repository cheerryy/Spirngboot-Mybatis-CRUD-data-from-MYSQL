package com.imooc.imooc1.config.dao;

import com.imooc.imooc1.entity.Area;

import java.util.List;

public interface AreaDao {
    //定义增删改查方法
    List<Area> queryArea();//查全部
    Area queryAreaById(int areaId);//查一个
    int insertArea(Area area);//增
    int updateArea(Area area);//改
    int deleteArea(int areaId);//删
}
