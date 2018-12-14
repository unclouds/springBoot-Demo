package com.myexample.demo.controller;

import com.myexample.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Autowired
    private GirlProperties girlProperties;
    /*
      value可以使用多个值：value={"/test","/haha"},多个rul映射一个请求。
     */
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String home(){
        return girlProperties.getAge()+girlProperties.getCupSize();
    }
}
