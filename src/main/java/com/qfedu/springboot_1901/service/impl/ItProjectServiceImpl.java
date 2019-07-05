package com.qfedu.springboot_1901.service.impl;

import com.qfedu.springboot_1901.dao.ItProjectDao;
import com.qfedu.springboot_1901.entity.ItProject;
import com.qfedu.springboot_1901.service.ItProjectService;
import com.qfedu.springboot_1901.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/7/5 15:27
 */
@Service
public class ItProjectServiceImpl implements ItProjectService {
    @Autowired
    private ItProjectDao projectDao;
    @Override
    public R save(ItProject project) {
        return R.exec(projectDao.save(project)!=null,null);

    }
    @Override
    public R queryAll() {
        return R.exec(true,projectDao.findAll());
    }

    @Override
    public R del(int id) {
        projectDao.deleteById(id);
        return R.exec(true,null);
    }

    @Override
    @Transactional
    public R update(int id, String name) {
        projectDao.update(id, name);
        return R.exec(true,null);
    }

    @Override
    public R all() {
        return R.exec(true, projectDao.all());
    }

    @Override
    public R sqlall() {
        return R.exec(true,projectDao.sqlall());
    }

    @Override
    public R findById(int id) {
        return R.exec(true,projectDao.findById(id));
    }

    @Override
    public R findByNameLike(String name) {
        if(name!=null && name.length()>0){
            name="%"+name+"%";
        }
        return R.exec(true,projectDao.findByNameLike(name));
    }
}
