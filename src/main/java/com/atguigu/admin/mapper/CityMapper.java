package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author Su
 * @create 2022-05-01 0:16
 */
@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    City getById(Integer id);

//    void insert(City city);

    @Insert("insert into city(`name`,`state`,`country`)values(#{name},${state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(City city);

}
