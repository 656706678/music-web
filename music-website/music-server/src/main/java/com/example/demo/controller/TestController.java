package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Controller
public class TestController {
    @Autowired
    private AdminServiceImpl adminService;

//   测试热部署
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String loginadmin(HttpServletRequest req, HttpSession session){

        return "88888";

    }
}
