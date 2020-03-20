package cn.itcast.service.impl;

import cn.itcast.domain.Consumer;
import cn.itcast.domain.ConsumerExample;
import cn.itcast.domain.PageBean;
import cn.itcast.mapper.ConsumerMapper;
import cn.itcast.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: servlettotals
 * @description:
 * @author: JClearLove
 * @Date: 2020/03/13 23:21
 */
@Service("consumerServiceImpl")
public class ConsumerServiceImpl implements ConsumerService {
   /* @Autowired
    private ConsumerMapper consumerMapper;*/

    private ApplicationContext context;
    private static final Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    @Override
    public List<Consumer> selectAll() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsumerMapper bean = context.getBean(ConsumerMapper.class);
        ConsumerExample consumerExample = new ConsumerExample();
        consumerExample.createCriteria().andIdIsNotNull();
        return bean.selectByExample(consumerExample);
    }

    @Override
    public int findAll(HashMap<String, String> condition) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsumerMapper bean = context.getBean(ConsumerMapper.class);
        return bean.findByCondition(condition);
    }


    @Override
    public int addConsumer(Consumer consumer) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsumerMapper bean = context.getBean(ConsumerMapper.class);
        return bean.insert(consumer);
    }

    @Override
    public int delConsumerById(Integer id) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsumerMapper consumerMapper = context.getBean(ConsumerMapper.class);
        ConsumerExample consumerExample = new ConsumerExample();
        consumerExample.createCriteria().andIdEqualTo(id);
        int index = consumerMapper.deleteByExample(consumerExample);
        logger.info("已删除consumer-id==" + index);
        return index;
    }

    @Override
    public Consumer findConsumerById(Integer id) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsumerMapper consumerMapper = context.getBean(ConsumerMapper.class);
        logger.info("已查询consumer-id==" + id);
        return consumerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateConsumerById(Consumer consumer) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsumerMapper consumerMapper = context.getBean(ConsumerMapper.class);
        ConsumerExample consumerExample = new ConsumerExample();
        consumerExample.createCriteria().andIdEqualTo(consumer.getId());
        logger.info("已更新用户信息consumer-id==" + consumer.getId());
        return consumerMapper.updateByExampleSelective(consumer, consumerExample);
    }

    @Override
    public int delSelectedConsumersByIds(List<Integer> ids) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsumerMapper consumerMapper = context.getBean(ConsumerMapper.class);
        ConsumerExample consumerExample = new ConsumerExample();
        consumerExample.createCriteria().andIdIn(ids);
        return consumerMapper.deleteByExample(consumerExample);
    }

    @Override
    public PageBean<Consumer> findUseByPages(Integer rows, Integer currentPage, Map<String, String[]> condition) {
        //1.定义模板初始化sql，作log 使用检查每次查询的sql是否拼接成功
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.创建空的PageBean对象
        PageBean<Consumer> pb = new PageBean<Consumer>();
        logger.info("====== 给PageBean的属性赋值 begin ======");
        // 设置参数- 防止点击第1后继续点击上一个
        if (currentPage <= 0) {
            currentPage = 1;
        }
        // 设置当前页的页码
        pb.setCurrentPage(currentPage);
        // 设置当前每一页的记录数
        pb.setRows(rows);
        // 遍历list.jsp 表单提交参数，筛选查询条件由Map<String, String[]> condition ---> HashMap<String, String> params
        Set<String> keySet = condition.keySet();
        // 定义参数的集合
        HashMap<String, String> params = new HashMap<String, String>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值,添加条件的值
                params.put(key, value);
                sb.append(" and ").append(key).append(" like ? ");
            }
        }
        logger.info("查询的sql语句是===" + sb.toString());
        // 设置list.jsp 根据条件查询，总的记录数
        int totalCount = findAll(params);
        // 设置总的记录数
        pb.setTotalCount(totalCount);
        // 查询当前页显示的记录
        int begin = (currentPage - 1) * rows;
        logger.info("查询当前页显示的记录查询参数设置为：" + "totalCount===" + totalCount + "===currentPage===" + currentPage + "===begin===" + begin + "===rows===" + rows);
        List<Consumer> list = findByPage(begin, rows, params);
        pb.setList(list);
        // 计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);
        logger.info("====== 给PageBean的属性赋值 end ======");
        return pb;
    }

    @Override
    public List<Consumer> findByPage(Integer begin, Integer rows, HashMap<String, String> params) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsumerMapper consumerMapper = context.getBean(ConsumerMapper.class);
        return consumerMapper.findByPagesCondition(begin, rows, params);

    }


}

