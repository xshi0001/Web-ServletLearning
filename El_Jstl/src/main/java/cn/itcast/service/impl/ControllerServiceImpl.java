package cn.itcast.service.impl;


import cn.itcast.domain.Controller;
import cn.itcast.domain.ControllerExample;
import cn.itcast.mapper.ControllerMapper;
import cn.itcast.service.ControllerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Controller)表服务实现类
 *
 * @author makejava
 * @since 2020-03-14 14:43:06
 */
@Service("controllerServiceImpl")
public class ControllerServiceImpl implements ControllerService {


    private ApplicationContext context;


    @Override
    public List<Controller> findControllerByNameAndPassword(String name, String password) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ControllerMapper controllerMapper = context.getBean(ControllerMapper.class);
        ControllerExample controllerExample = new ControllerExample();
        controllerExample.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        return controllerMapper.selectByExample(controllerExample);
    }


}