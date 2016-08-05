package com.kaishengit.Service;

import com.kaishengit.dao.InsuranceDao;
import com.kaishengit.pojo.Insurance;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by 20330 on 2016/8/4.
 */
@Named
@Transactional
public class InsuranceService {
    @Inject
    private InsuranceDao insuranceDao;

    public void saveInsurance(Insurance insurance){
        insuranceDao.save(insurance);

    }

    public List<Insurance> findAllInsurance(){
        return insuranceDao.findAll();
    }

    public void delInsurance(Integer id){
        insuranceDao.delete(id);

    }

    public Insurance findInsuranceById(Integer id){
        return insuranceDao.findById(id);
    }

}
