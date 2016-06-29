package com.kaishengit.mapper;

import com.kaishengit.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by 20330 on 2016/6/28.
 */
public interface UserMapper {
    @Select("select * from t_user limit #{start},#{size}")
    List<User> findByPage(@Param("start")int start,@Param("size")int pageSize);
    List<User> findByQueryParam(Map<String,Object> queryParam);
    User findByParams(@Param("username")String username,@Param("pwd")String password);
    User findByMap(Map<String,Object> param);
    @Select("select * from t_user where id=#{id}")
    @Results({
            @Result(column ="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column="address",property="address"),
            @Result(column="password",property="password"),
            @Result(column="email",property="email"),
            @Result(column="avatar",property="avatar"),
            @Result(property="tagList",javaType=List.class,column="id",many=@Many(
                    select="com.kaishengit.mapper.TagMapper.findByUserId"
            ))
    })
    User findById(Integer id);
    @Insert(" insert INTO t_user(username, address, password,email,avatar) \n" +
            " VALUES (#{username},#{address},#{password},#{email},#{avatar})")
    void save(User user);
    @Update("UPDATE t_user SET password=#{password},address=#{address}\n" +
            "WHERE id=#{id}")
    void update(User user);
    @Delete("delete from t_user where id=#{id}")
    void del(Integer id);
    List<User> findAll();
}
