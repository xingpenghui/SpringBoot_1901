package com.qfedu.springboot_1901.service;

import com.qfedu.springboot_1901.entity.ItProject;
import com.qfedu.springboot_1901.vo.R;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/7/5 15:26
 */
public interface ItProjectService {
    R save(ItProject project);
    R queryAll();
    R del(int id);
    R update(int id,String name);
    R all();
    R sqlall();
    R findById(int id);
    R findByNameLike(String name);
}
