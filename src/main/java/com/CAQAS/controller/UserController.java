package com.CAQAS.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.pojo.User;
import com.CAQAS.service.UserService;

@Controller
public class UserController {
	@Resource  
    private UserService userService;  
      
	/**
	 * 根据用户Id查询用户信息
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
    @RequestMapping("/selectUserById")
    public Map<String, Object> selectUserById(HttpServletRequest request/*, HttpSession session*/){  
		Map<String, Object> map = new HashMap<String, Object>();
        int userId = Integer.parseInt(request.getParameter("id"));
//        String userName = request.getParameter("userName");
//        User userSession = (User) session.getAttribute("user");
//        System.out.println("session 测试：" + userSession.getUserPassword());
        User user = this.userService.selectUser(userId);  
        map.put("result", user);
        return map;
    }
	
	/**
	 * 获取session信息
	 * @param session session对象
	 * @return session结果信息
	 */
	@ResponseBody
	@RequestMapping("/getUserSession")
	public User getUserSession(HttpSession session) {
		User user = (User) session.getAttribute("user");
		return user;
	}
	
	/**
	 * 登录验证
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Map<String, Object> login(HttpServletRequest request, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		User user = userService.selectByUserName(userName);
		if (user != null && !"".equals(user.getUserPassword()) 
				&& user.getUserPassword().equals(userPassword)) {
			map.put("result", "验证成功");
			session.setAttribute("user", user);
		} else {
			map.put("result", "验证失败");
		}
		return map;
	}
	
	/**
	 * 注销
	 * @param session session对象
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public Map<String, Object> logout(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		session.removeAttribute("user");
		map.put("result", 1);
		return map;
	}
}
