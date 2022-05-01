package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Su
 * @create 2022-04-30 23:01
 */

@Mapper
public interface OrderMapper {

     Order getOrderById(@Param("orderId") Integer orderId);


}
