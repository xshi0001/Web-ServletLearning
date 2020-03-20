package cn.itcast.service.impl;

import cn.itcast.domain.Controller;
import cn.itcast.domain.ControllerExample;
import cn.itcast.mapper.ControllerMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: JClearLove
 * @Date: 2020/03/14 23:26
 */
public class ControllerServiceImplTest {


    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void findControllerByNameAndPasswordTest() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ControllerMapper controllerMapper = context.getBean(ControllerMapper.class);
        System.out.print("xxxxxxxxxxxxxxx"+"ControllerServiceImpl");
        ControllerExample controllerExample = new ControllerExample();
        controllerExample.createCriteria().andNameEqualTo("admin").andPasswordEqualTo("admin");
        List<Controller> controllers = controllerMapper.selectByExample(controllerExample);
        for (Controller controller : controllers) {
            String s = controller.toString();
            System.out.println(s);
        }
    }
}