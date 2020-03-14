package cn.itcast.service.impl;

import cn.itcast.domain.Consumer;
import cn.itcast.domain.ConsumerExample;
import cn.itcast.mapper.ConsumerMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * @Description:
 *
 *
 * @Author: JClearLove
 * @Date: 2020/03/14 08:27
 */
public class ConsumerServiceImplTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void findAll() {

        ConsumerMapper bean = context.getBean(ConsumerMapper.class);
        ConsumerExample consumerExample = new ConsumerExample();
        consumerExample.createCriteria().andIdIsNotNull();
        List<Consumer> consumers = bean.selectByExample(consumerExample);
        for (Consumer consumer : consumers) {
            System.out.println(consumer.getName());
        }
    }
}