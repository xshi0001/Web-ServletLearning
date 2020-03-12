package com.itheima.mapper;

import com.itheima.pojo.Login;
import com.itheima.service.impl.LoginServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: JClearLove
 * @Date: 2020/03/11 15:40
 */
public class UserMapperTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }


    @Test
    public void selectByPrimaryKey() {
        LoginMapper bean = this.context.getBean(LoginMapper.class);


        HashMap<String, String> map = new HashMap<>();
        map.put("username", "shixiaokai");
        map.put("password", "admin");

        //3.创建User对象
        Login loginUser = new Login();
        //3.2使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // 通过数据库查询 登陆信息
        LoginServiceImpl loginService = new LoginServiceImpl();
        Login loginer = loginService.queryByLogin(loginUser);


        System.out.println(loginer.toString());
    }
}