package com.kaishengit.mapper;

import com.kaishengit.pojo.Role;

import java.util.List;

/**
 * Created by 20330 on 2016/7/8.
 */
public interface RoleMapper {
    Role findById(Integer id);

    List<Role> findAll();
}
