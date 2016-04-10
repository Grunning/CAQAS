package com.CAQAS.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.CAQAS.pojo.User;
import com.CAQAS.service.impl.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMMM {
	@Resource  
    private IUserService userService = null;
	
	@Test
    public void test1() {  
        User user = userService.selectUser(1);
        System.out.println(user.getUserName());
    }
}