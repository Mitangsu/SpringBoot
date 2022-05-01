package com.atguigu.admin.service;

import com.atguigu.admin.bean.City;

/**
 * @author Su
 * @create 2022-05-01 5:45
 */
public interface CityService {

    public City getById(Integer id);

    public void saveCity(City city);

}
