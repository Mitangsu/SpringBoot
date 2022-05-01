package com.atguigu.admin.controller;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.Order;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.CityService;
import com.atguigu.admin.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Su
 * @create 2022-04-28 22:30
 */
@Controller
public class indexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired(required = false)
    OrderService orderService;

    @Autowired(required = false)
    CityService cityService;

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }


    @ResponseBody
    @GetMapping("/o")
    public Order getByOrderId(@RequestParam("orderId") Integer orderId){

        return orderService.getOrderById(orderId);
    }

    @ResponseBody
    @GetMapping("/oo")
    public City getByCityId(@RequestParam("id") Integer id){

        return cityService.getById(id);
    }






    @ResponseBody
    @GetMapping("/sql")
    public String queryFormDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }

    /**
     * 来登录页面
     * @return
     */
    @GetMapping(value = {"/","login"})
    public String loginPage(){

        return "login";
    }

    /**
     * 登录的请求
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(StringUtils.hasLength(user.getUsername()) && "1".equals(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }

    }

    /**
     *
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
//        //是否登录。拦截器,过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser!=null){
//            return "main";
//        }else{
//            model.addAttribute("msg","请重新登陆");
//            return "login";
//        }
        return "main";

    }


}














