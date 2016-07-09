package com.kaishengit.service;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.RoleMapper;
import com.kaishengit.mapper.UserLogMapper;
import com.kaishengit.mapper.UserMapper;
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
}
