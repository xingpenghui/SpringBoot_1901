package com.qfedu.springboot_1901.vo;

import lombok.Data;

/**
 *@Author feri
 *@Date Created in 2019/7/5 15:26
 */
@Data
public class R {
    private int code;
    private Object data;
    public static R exec(boolean istrue,Object obj){
        R r=new R();
        r.setData(obj);
        if(istrue){
            r.setCode(200);
        }else {
            r.setCode(400);
        }
        return r;
    }
}
