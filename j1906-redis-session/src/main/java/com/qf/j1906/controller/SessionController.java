package com.qf.j1906.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author: Brendan Li
 * @description Session共享
 * @Date: 2019/11/27/14:14
 */

@RestController
public class SessionController {

    @RequestMapping("/write")
    public String write(HttpSession session,String name){
        session.setAttribute("myname",name);
        return "OK";
    }

    @RequestMapping("/read")
    public String read(HttpSession session){
        String  myname = (String) session.getAttribute("myname");
        return myname+" welcome to redis world !";
    }
}
