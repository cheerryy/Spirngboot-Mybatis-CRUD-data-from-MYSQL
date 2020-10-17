package com.imooc.imooc1.config.dao;

import com.imooc.imooc1.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;//本次用于测试的主角

    @Test
    public void queryArea() {
        List<Area> areaList=areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
//        area_id=1，看name是不是dong
        Area area = areaDao.queryAreaById(1);
        assertEquals("dong",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area=new Area();
        area.setAreaName("nan");
        area.setPriority(1);
        int effectNum=areaDao.insertArea(area);
        assertEquals(1,effectNum);
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area=new Area();
        area.setAreaName("xi");
        area.setAreaId(3);
//        area.setLastEditTime(new Date());
        int effectNum = areaDao.updateArea(area);
        assertEquals(1,effectNum);
    }

    @Test
    @Ignore
    public void deleteArea() {
        int effectNum=areaDao.deleteArea(3);
        assertEquals(1,effectNum);
    }
}