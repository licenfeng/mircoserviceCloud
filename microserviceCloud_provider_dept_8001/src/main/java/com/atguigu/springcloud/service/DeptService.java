package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;

import java.util.List;

/**
 * Created by user on 2019/1/16.
 *
 * @Author user
 */
public interface DeptService {
    public boolean add(Dept dept);
    public Dept get( String id);
    public List<Dept> list();

}
