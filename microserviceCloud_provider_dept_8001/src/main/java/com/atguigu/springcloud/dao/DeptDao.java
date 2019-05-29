package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by user on 2019/1/16.
 *
 * @Author user
 */
@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept findById(String id);
    public List<Dept> findAll();

}
