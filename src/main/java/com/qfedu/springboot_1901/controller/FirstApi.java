package com.qfedu.springboot_1901.controller;

import com.qfedu.springboot_1901.model.Company;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/7/4 16:22
 */
@Controller
public class FirstApi {
    @RequestMapping("first/hi.do")
    public String hi(Model model){
        model.addAttribute("str1","我是xxx");
        model.addAttribute("num1",1001);
        Company company = new Company();
        company.setId(1);
        company.setName("河南狼来了科技有限公司");
        company.setAddress("郑州二七海为");
        company.setNums(100);
        model.addAttribute("company",company);
        model.addAttribute("sex","0");
        List<Company> list=new ArrayList<>();
        for(int i=1;i<10;i++){
            Company cm = new Company();
            cm.setId(i);
            cm.setName("河南狼来了"+i);
            cm.setAddress("郑州二七海为");
            cm.setNums(100);
            list.add(cm);
        }
        model.addAttribute("companylist",list);
        return "first";

    }
}
