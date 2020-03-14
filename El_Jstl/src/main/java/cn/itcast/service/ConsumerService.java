package cn.itcast.service;

import cn.itcast.domain.Consumer;
import cn.itcast.domain.ConsumerExample;
import cn.itcast.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface ConsumerService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<Consumer> findAll();
}
