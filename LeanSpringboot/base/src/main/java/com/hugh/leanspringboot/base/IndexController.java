package com.hugh.leanspringboot.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("index")
    public void index(Integer index) throws InterruptedException {
        System.out.println("index = " + index);
        Thread.sleep(2000);
    }

    @PostMapping("upload")
    public void upload(HttpServletRequest request , HttpServletResponse response,  @RequestParam("file")MultipartFile file ) {
        // 测试MultipartFile接口的各个方法
        System.out.println("文件类型ContentType=" + file.getContentType());
        System.out.println("文件组件名称Name=" + file.getName());
        System.out.println("文件原名称OriginalFileName=" + file.getOriginalFilename());
        System.out.println("文件大小Size=" + file.getSize()/1024 + "KB");
    }
}

