package com.kaishengit.service;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.RoleMapper;
import com.kaishengit.mapper.UserLogMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserLog;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created by 20330 on 2016/7/8.
 */
@Named
public class UserService {
    @Inject
    private UserMapper userMapper;
    @Inject
    private UserLogMapper userLogMapper;
    @Inject
    private RoleMapper roleMapper;

    /*
    * 创建用户的登录日志
    * */
    public void saveUserLogin(String ip) {
        UserLog userLog=new UserLog();
        userLog.setLoginip(ip);
        userLog.setLogintime(DateTime.now().toString("yyyy-mm--dd hh:MM"));
        userLog.setUserid(ShiroUtil.getCurrentUserId());
        userLogMapper.save(userLog);
    }
    /**
     * 修改用户密码*/
    public void changePassword(String password) {
        User user=ShiroUtil.getCurrentUser();
        user.setPassword(DigestUtils.md5Hex(password));
        userMapper.updateUser(user);
    }

    /**
     *获取当前登录用户的登录日志
     * @param start
     * @param length
     * @return
     */
    public List<UserLog> findCurrentUserLog(String start, String length) {
        Map<String,Object> param= Maps.newHashMap();
        param.put("userId",ShiroUtil.getCurrentUserId());
        param.put("start",start);
        param.put("length",length);
        return userLogMapper.findByParam(param);
    }

    /**
     * 获取当前登陆用户的日志总数
     * @return
     */
    public Long findCurrentUserLogCount() {
        Map<String,Object> param=Maps.newHashMap();
        param.put("userId",ShiroUtil.getCurrentUserId());
        return userLogMapper.countByParam(param);

    }

    /**
     * 根据查询参数获取用户列表
     * @param params
     * @return
     */
    public List<User> findUserByParam(Map<String, Object> params) {
        return userMapper.findByParam(params);
    }

    /**
     * 获取用户的总数量
     * @return
     */
    public Long findUserCount() {
        return  userMapper.count();
    }

    /**
     * 获取过滤后的用户总数
     * @param params
     * @return
     */
    public Long findUserCountByParam(Map<String, Object> params) {
        return userMapper.countByParam(params);
    }

    /**
     * 获取所有的角色
     * @return
     */
    public List<Role> findAllRole() {
        return roleMapper.findAll();

    }

    /**
     * 添加新用户
     * @param user
     */
    public void saveUser(User user) {
        user.setEnable(true);
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));

        //TODO向微信公众平台注册账号

        userMapper.save(user);

    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */

    public User findUserByUserName(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 重置用户密码
     * @param id 用户ID
     */
    public void resetUserPassword(Integer id) {
        User user=userMapper.findById(id);
        if(user!=null){
            user.setPassword(DigestUtils.md5Hex("000000"));
            userMapper.updateUser(user);
        }
    }

    /**
     * 根据用户ID查找用户
     * @param id
     * @return
     */
    public User findUserById(Integer id) {
        return userMapper.findById(id);
    }

    /**
     * 修改用户信息
     * @param user
     */
    public void editUser(User user) {
        userMapper.updateUser(user);
    }
}
