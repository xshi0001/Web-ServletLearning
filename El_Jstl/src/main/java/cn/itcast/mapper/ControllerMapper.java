package cn.itcast.mapper;


import cn.itcast.domain.Controller;
import cn.itcast.domain.ControllerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ControllerMapper {
    int countByExample(ControllerExample example);

    int deleteByExample(ControllerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Controller record);

    int insertSelective(Controller record);

    List<Controller> selectByExample(ControllerExample example);

    Controller selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Controller record, @Param("example") ControllerExample example);

    int updateByExample(@Param("record") Controller record, @Param("example") ControllerExample example);

    int updateByPrimaryKeySelective(Controller record);

    int updateByPrimaryKey(Controller record);


}