package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 文件上传测试
 *
 * @author Su
 * @create 2022-04-29 23:47
 */
@Slf4j
@Controller
public class FormTestControler {

    @GetMapping("/form_layouts")
    public String form_layouts() {

        return "form/form_layouts";
    }

    /**
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     * @RequestPart这个注解用在multipart/form-data表单提交请求的方法上。 MultipartFile自动封装上传的文件
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息:email={},username={},headerImg={},photos={}",
                email, username, headerImg.getSize(), photos.length);

        if (!headerImg.isEmpty()) {
            //保存到文件服务器,OSS服务器
            String originalFilename = headerImg.getOriginalFilename();//获取原始的文件名
            headerImg.transferTo(new File("D:\\yxdz\\" + originalFilename));//传输到哪里
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\yxdz\\" + originalFilename));
                }

            }
        }


        return "main";
    }
}















