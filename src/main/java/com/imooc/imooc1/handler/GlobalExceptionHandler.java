package com.imooc.imooc1.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
//    所有的exception都同一处理
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
//    请求参数,异常
    private Map<String,Object> exceptionHandler(HttpServletRequest request,Exception e){
        Map<String,Object> modelMap=new HashMap<String, Object>();
//        捕获道异常，肯定是false
        modelMap.put("success",false) ;
//        返回为什么错误
        modelMap.put("errMsg",e.getMessage());
//        最好还要写日志
        return modelMap;
    }
}
