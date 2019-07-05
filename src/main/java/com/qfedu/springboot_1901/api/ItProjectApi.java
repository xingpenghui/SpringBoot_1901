package com.qfedu.springboot_1901.api;

import com.qfedu.springboot_1901.entity.ItProject;
import com.qfedu.springboot_1901.service.ItProjectService;
import com.qfedu.springboot_1901.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Author feri
 *@Date Created in 2019/7/5 15:30
 */
@RestController
public class ItProjectApi {
    @Autowired
    private ItProjectService projectService;
    @GetMapping("/project/all.do")
    public R all(){
        return projectService.queryAll();
    }
    @PostMapping("/project/save.do")
    public R save(@RequestBody ItProject project){
        return projectService.save(project);
    }
    @DeleteMapping("project/del.do")
    public R del(int id){
        return projectService.del(id);
    }
    @GetMapping("project/jpqlall.do")
    public R all1(){
        return projectService.all();
    }
    @GetMapping("project/sqlall.do")
    public R all2(){
        return projectService.sqlall();
    }
    @PutMapping("project/update.do")
    public R update(int id,String name){
        return projectService.update(id, name);
    }
    @GetMapping("project/methodsignle.do")
    public R single(int id){
        return projectService.findById(id);
    }
    @GetMapping("project/methodlike.do")
    public R like(String name){
        return projectService.findByNameLike(name);
    }

}
