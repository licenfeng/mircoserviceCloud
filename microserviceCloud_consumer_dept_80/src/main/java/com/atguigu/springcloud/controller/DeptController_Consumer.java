package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by user on 2019/2/9.
 *
 * @Author user
 */
@RestController
public class DeptController_Consumer {
    //private static final String restful_prefix="http://localhost:8001";
    private static final String restful_prefix="http://MICROSERVICECLOUD-DEPT";   //通过微服务名访问
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value ="/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return  restTemplate.postForObject(restful_prefix+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value ="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id )
    {
        return  restTemplate.getForObject(restful_prefix+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(restful_prefix + "/dept/list", List.class);
    }
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(restful_prefix+"/dept/discovery", Object.class);
    }

}
