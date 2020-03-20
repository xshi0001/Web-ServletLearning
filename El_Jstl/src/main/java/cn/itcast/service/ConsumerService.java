package cn.itcast.service;

import cn.itcast.domain.Consumer;
import cn.itcast.domain.PageBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface ConsumerService {

    /**
     * 查询所有用户信息
     *
     * @return List<Consumer>
     */
    List<Consumer> selectAll();

    /**
     * 查询符合条件的所有用户信息
     *
     * @param condition 查询条件
     * @return int
     */
    int findAll(HashMap<String, String> condition);


    /**
     * 添加用戶
     *
     * @return
     */
    int addConsumer(Consumer consumer);

    /**
     * 删除功能
     *
     * @param id 删除用户的id
     * @return 影响的行数
     */
    int delConsumerById(Integer id);

    Consumer findConsumerById(Integer id);


    int updateConsumerById(Consumer consumer);

    int delSelectedConsumersByIds(List<Integer> ids);

    /**
     * 分页条件查询
     *
     * @param rows        查询当前页面多少行
     * @param currentPage 查询当前页
     * @param condition   查询条件
     * @return PageBean<Consumer> list.jsp页面封装类
     */
    PageBean<Consumer> findUseByPages(Integer currentPage, Integer rows, Map<String, String[]> condition);

    /**
     * @param begin 每一页起始索引
     * @param rows  每一页多少行
     * @param params  参数转换
     * @return List<Consumer>
     */
    List<Consumer> findByPage(Integer begin, Integer rows, HashMap<String, String> params);


}
