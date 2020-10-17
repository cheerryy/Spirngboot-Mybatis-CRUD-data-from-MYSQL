package com.imooc.imooc1.service.impl;

import com.imooc.imooc1.config.dao.AreaDao;
import com.imooc.imooc1.entity.Area;
import com.imooc.imooc1.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName()!=null&&!"".equals(area.getAreaName())){
//            名字不为空时，给他设置默认的时间信息
                area.setCreateTime(new Date());
                area.setLastEditTime(new Date());
//                开始插入操作
                try {
                    int effectNum=areaDao.insertArea(area);
                    if(effectNum>0){
//                        插入成功
                        return true;
                    }
                    else {
                        throw new RuntimeException("插入信息失败");
                    }
                }catch (Exception e){
                    throw new RuntimeException("插入失败："+e.getMessage());
                }
        }else {
            throw new RuntimeException("信息不能为空");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
//        判断id不为空
        if(area.getAreaId()!=null&&area.getAreaId()>0){
            area.setLastEditTime(new Date());
            try {
                int effectNum=areaDao.updateArea(area);
                if (effectNum>0){
                    return true;
                }else {
                    throw new RuntimeException("更新区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("更新信息失败："+e.toString());
            }
        }else {
            throw new RuntimeException("不能为空");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try {
                int effectNum=areaDao.deleteArea(areaId);
                if(effectNum>0){
                    return true;
                }else {
                    throw new RuntimeException("删除失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除失败："+e.toString());
            }
        }else {
            throw new RuntimeException("不能为空");
        }
    }
}
