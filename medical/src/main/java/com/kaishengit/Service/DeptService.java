package com.kaishengit.Service;

import com.kaishengit.dao.DeptDao;
import com.kaishengit.pojo.Dept;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by 20330 on 2016/8/4.
 */
@Named
@Transactional
public class DeptService {
    @Inject
    private DeptDao deptDao;
    public void saveDept(Dept dept){
        deptDao.save(dept);
    }

    public void delDept(Integer id){
        deptDao.delete(id);
    }

    public Dept findDeptById(Integer id){
        return  deptDao.findById(id);
    }

    public List<Dept> findAllDept(){
        return deptDao.findAll();
    }
}
