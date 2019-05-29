package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 2019/1/16.
 *
 * @Author user
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") String id){
        return deptService.get(id);
    }
    @RequestMapping(value = "dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    @RequestMapping(value="/dept/discovery",method = RequestMethod.GET)
    public Object discovery() {
       List<String>list = discoveryClient.getServices();
        System.out.println(list+"===========");
        List<ServiceInstance>serviceInstances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance serviceInstance : serviceInstances) {
            System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
       return discoveryClient;
    }
}
