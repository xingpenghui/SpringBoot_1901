package com.qfedu.springboot_1901.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *@Author feri
 *@Date Created in 2019/7/5 15:20
 * 项目类
 */
@Entity
@Table(name = "t_itproject")
@Data
//@NamedQueries({@NamedQuery(name = "",query = ""),
//        @NamedQuery(name = "",query = "")})
//@NamedQuery(name = "getAll",query = "from ItProject")
public class ItProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的生成策略
    private Integer id;
    @Column(length = 30)
    private String name;
    private int persons;
    private int month;
    @Column(length = 50)
    private String info;
}
