package com.imooc.imooc1.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.imooc1.entity.Area;
import com.imooc.imooc1.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

//    查询，返回所有的信息
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        List<Area> list=areaService.getAreaList();
//        根据areaList这个key去获取list
        modelMap.put("areaList",list);
        return modelMap;
    }

//    通过id获取信息
    @RequestMapping(value = "/getareabyid",method = RequestMethod.GET)
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        Area area=areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

//    添加区域信息
    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
//    因为打算一整个表单一起提交，所以用post
    private Map<String,Object> addArea(@RequestBody Area area){
//函数的参数不能直接是Area area，因为前端不能直接传Area对象给我们 只能传json之类的
//        因此用@RequestBody，表示接受的是除json啥的之外的内容
        Map<String,Object> modelMap=new HashMap<String, Object>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    private Map<String,Object> modifyArea(@RequestBody Area area)throws JsonParseException, JsonMappingException, IOException{
        Map<String,Object> modelMap=new HashMap<String, Object>();
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    private Map<String,Object> removeArea(Integer areaId){
        Map<String,Object> modelMap=new HashMap<String, Object>();
//        success作为key，保存删除函数的返回值（bool）
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }

}
