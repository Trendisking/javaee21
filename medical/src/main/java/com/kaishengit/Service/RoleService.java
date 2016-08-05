package com.kaishengit.Service;

import com.kaishengit.dao.RoleDao;
import com.kaishengit.pojo.Role;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by 20330 on 2016/8/4.
 */
@Named
@Transactional
public class RoleService {
    @Inject
    private RoleDao roleDao;
    public void saveRole(Role role){
        roleDao.save(role);
    }

    public void delRole(Integer id){
        roleDao.delete(id);
    }

    public Role findRoleById(Integer id){
        return roleDao.findById(id);
    }

   public List<Role> findAllRole(){
       return roleDao.findAll();
   }
}
