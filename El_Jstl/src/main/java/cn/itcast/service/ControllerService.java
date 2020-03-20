package cn.itcast.service;


import cn.itcast.domain.Controller;

import java.util.List;

/**
 * (Controller)表服务接口
 *
 * @author makejava
 * @since 2020-03-14 14:43:04
 */
public interface ControllerService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<Controller> findControllerByNameAndPassword(String name, String password);



}