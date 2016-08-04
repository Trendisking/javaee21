package com.kaishengit.Service;

import com.kaishengit.dao.RoleDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by 20330 on 2016/7/8.
 */
@Named
public class ShiroRealm extends AuthorizingRealm {
    @Inject
    private UserDao userDao;
    @Inject
    private RoleDao roleDao;

    /*验证用户是否具有某项权限*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user=(User)principalCollection.getPrimaryPrincipal();
        if(user!=null){
            //根据用户的RollID获取role对象
            Integer roleId=user.getRoleid();
            Role role=roleDao.findById(roleId);
            //将用户的角色名称赋值给info
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            info.addRole(role.getRolename());
            return info;
        }
        return null;
    }
    /*验证用户的账号或密码是否正确
    * authenticationToken是UsernamePasswordToken的父类
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();
        User user=userDao.findByUsername(username);//根据账号查找对应的对象

       if(user !=null){
           if(!user.getEnable()){
              throw new LockedAccountException("该账号已被禁用");
           }
           return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
       }else{
            throw new UnknownAccountException("账号或密码错误");
        }
    }
}
