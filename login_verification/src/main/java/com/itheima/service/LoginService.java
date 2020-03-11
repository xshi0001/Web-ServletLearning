package com.itheima.service;

import com.itheima.pojo.Login;

/**
 * (Login)表服务接口
 *
 * @author makejava
 * @since 2020-03-11 16:40:34
 */
public interface LoginService {

    Login queryByLogin(Login login);

}