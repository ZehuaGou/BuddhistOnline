package com.buddhist.user.service;

import com.buddhist.user.model.User;

/*
* 用户业务层接口
* */
public interface UserService
{
    /*
    * 添加一个用户信息
    * */
    void insertUser(User user);

    /*
    * 根据id删除用户信息
    * */
    void deleteUserById(Integer id);

    /*
     * 修改用户信息
     * */
    void updateUser(User user);

    /*
     * 根据id查询用户信息
     * */
    User selectUserById(Integer id);

    /*
     * 检验手机号密码是否正确
     * */
    User checkPhoneAndPassword(String phone, String password);

    /*
     * 查询该用户名称是否已存在
     * */
    User checkPhoneIfExist(String phone);
}
