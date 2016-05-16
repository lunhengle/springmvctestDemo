package com.lhl.mvc.controller;

import com.lhl.mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2016/3/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getUser/{id}")
    public ModelAndView view(@PathVariable("id") Long id, HttpServletRequest req) {
        User user = new User();
        user.setId(id);
        user.setName("lunhengle");
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user/view");
        return mv;
    }
}
