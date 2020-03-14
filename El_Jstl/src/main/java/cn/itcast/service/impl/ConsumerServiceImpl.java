package cn.itcast.service.impl;

import cn.itcast.domain.Consumer;
import cn.itcast.domain.ConsumerExample;
import cn.itcast.mapper.ConsumerMapper;
import cn.itcast.service.ConsumerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: servlettotals
 * @description:
 * @author: JClearLove
 * @Date: 2020/03/13 23:21
 */
@Service("consumerServiceImpl")
public class ConsumerServiceImpl implements ConsumerService {

    private ApplicationContext context;


    @Override
    public List<Consumer> findAll() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ConsumerMapper bean = context.getBean(ConsumerMapper.class);
        ConsumerExample consumerExample = new ConsumerExample();
        consumerExample.createCriteria().andIdIsNotNull();
        return bean.selectByExample(consumerExample);
    }
}

