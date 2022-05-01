package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.mapper.CityMapper;
import com.atguigu.admin.service.CityService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Su
 * @create 2022-05-01 0:19
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(Integer id){
        return cityMapper.getById(id);
    }

    public void saveCity(City city){
       cityMapper.insert(city);
    }

}
