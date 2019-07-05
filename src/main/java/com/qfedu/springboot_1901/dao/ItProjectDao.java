package com.qfedu.springboot_1901.dao;

import com.qfedu.springboot_1901.entity.ItProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/7/5 15:24
 */
public interface ItProjectDao extends JpaRepository<ItProject,Integer> {
    //基于JPQL语法 类就是表 对象就是数据 属性就是字段
    @Modifying //标记 修改或删除语句
    @Query(value = "update ItProject p set p.name=:name where p.id=:id")
    void update(@Param("id") int id, @Param("name") String name);
    @Query(value = "from ItProject ")
    List<ItProject> all();

    //基于SQL操作
    @Query(value = "select * from t_itproject order by id desc",nativeQuery =true)
    List<ItProject> sqlall();

    //方法名解析查询
    ItProject findById(int id);
    List<ItProject> findByNameLike(String name);

}
