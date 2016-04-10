package com.CAQAS.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.pojo.User;
import com.CAQAS.service.UserService;

@Controller  
public class UserController {
	@Resource  
    private UserService userService;  
      
	@ResponseBody
    @RequestMapping("/selectUserById")
    public User selectUserById(HttpServletRequest request){  
        int userId = Integer.parseInt(request.getParameter("id")); 
        User user = this.userService.selectUser(userId);  
        return user;
    }
}
