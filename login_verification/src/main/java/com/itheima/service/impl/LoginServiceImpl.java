package com.itheima.service.impl;


import com.itheima.mapper.LoginMapper;
import com.itheima.pojo.Login;
import com.itheima.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * (Login)表服务实现类
 *
 * @author makejava
 * @since 2020-03-11 16:40:35
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginDao;


    @Override
    public Login queryByLogin(Login login) {
        return loginDao.selectByNameAndPassword(login);
    }
}