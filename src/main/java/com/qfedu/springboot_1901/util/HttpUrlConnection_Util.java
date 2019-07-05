package com.qfedu.springboot_1901.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 *@Author feri
 *@Date Created in 2019/7/5 16:52
 */
public class HttpUrlConnection_Util {
    //819bd521a100686c112ed92bd696635c
    public static void main(String[] args) throws IOException {
        String city=URLEncoder.encode("郑州","UTF-8");
        //1、创建url对象
        URL url=new URL("http://v.juhe.cn/weather/index?key=819bd521a100686c112ed92bd696635c&cityname="+city);
//        System.out.println("查询天气："+HttpUtil.httpGet("http://v.juhe.cn/weather/index?key=819bd521a100686c112ed92bd696635c&cityname="+city));
        System.out.println("查询是不是富翁："+HttpUtil.httpPost("http://apis.juhe.cn/lottery/types","key=a38d598021e48c15237a1a75f1666d72"));
    }
}
