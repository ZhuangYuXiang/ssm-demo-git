package com.zyx.web;

import com.zyx.bean.User;
import com.zyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public ModelAndView hello(HttpServletRequest request){
        User user = new User();
        ModelAndView modelAndView = new ModelAndView();

        //建立session
        HttpSession session = request.getSession(true);
        //将登陆信息存放session
        session.setAttribute("session","123");

        System.err.println("新创建sessionid"+session.getId());
        Map<String,User> data = new HashMap<>();
        data.put("hello",user);
        modelAndView.addAllObjects(data);
        return modelAndView;
    }
    @PostMapping("/world")
    public ModelAndView world(HttpServletRequest request){
        /*HttpSession session = request.getSession(true);
        System.err.print("--------------session值------------------"+session.getAttribute("session"));*/
        String admin = request.getParameter("admin");
        Map<String,String> data = new HashMap<>();
        ModelAndView model = new ModelAndView();
        data.put("world",admin);
        model.addAllObjects(data);
        return model;
    }
}
