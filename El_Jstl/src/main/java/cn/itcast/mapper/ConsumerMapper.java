package cn.itcast.mapper;

import cn.itcast.domain.Consumer;
import cn.itcast.domain.ConsumerExample;
import org.apache.ibatis.annotations.Param;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ConsumerMapper {
    int countByExample(ConsumerExample example);

    int deleteByExample(ConsumerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Consumer record);

    int insertSelective(Consumer record);

    List<Consumer> selectByExample(ConsumerExample example);

    Consumer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Consumer record, @Param("example") ConsumerExample example);

    int updateByExample(@Param("record") Consumer record, @Param("example") ConsumerExample example);

    int updateByPrimaryKeySelective(Consumer record);

    int updateByPrimaryKey(Consumer record);

    /**
     * 分页查询
     * @param start 起始索引
     * @param pageSize 每页展示记录数
     * @param condition 用户查询条件
     * @return 返回每一页的记录详情
     */
    List<Consumer> findByPagesCondition(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("params") HashMap<String, String> condition);

    /**
     * 根据用户条件，返回所有符合条件记录总数
     * @param condition 用户查询条件
     * @return 记录总数
     */
    int findByCondition(@Param("params") HashMap<String, String> condition);
}