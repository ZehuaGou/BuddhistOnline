package com.buddhist.user.service.impl;

import com.buddhist.user.mapper.UserMapper;
import com.buddhist.user.model.User;
import com.buddhist.user.model.UserExample;
import com.buddhist.user.service.DesignationService;
import com.buddhist.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 用户业务层实现类
 * */
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    /*
     * 添加一个用户信息
     * */
    @Override
    public void insertUser(User user)
    {
        userMapper.insert(user);
    }

    /*
     * 根据id删除用户信息
     * */
    @Override
    public void deleteUserById(Integer id)
    {
        //根据id删除用户信息
        userMapper.deleteByPrimaryKey(id);
    }

    /*
     * 修改用户信息
     * */
    @Override
    public void updateUser(User user)
    {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /*
     * 根据id查询用户信息
     * */
    @Override
    public User selectUserById(Integer id)
    {
        return userMapper.selectByPrimaryKey(id);
    }

    /*
     * 检验手机号密码是否正确
     * */
    @Override
    public User checkPhoneAndPassword(String phone, String password)
    {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        criteria.andPasswordEqualTo(password);

        List<User> userList = userMapper.selectByExample(example);

        if (userList.size() > 0)
        {
            return userList.get(0);
        }

        return null;
    }

    /*
     * 查询该手机号是否已存在
     * */
    @Override
    public User checkPhoneIfExist(String phone)
    {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);

        List<User> userList = userMapper.selectByExample(example);

        if (userList.size() > 0)
        {
            return userList.get(0);
        }

        return null;
    }
}
