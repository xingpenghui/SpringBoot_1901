package com.qfedu.springboot_1901.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/7/5 17:49
 */
public class HttpClient_Main {
    public static void main(String[] args) throws IOException {
        String city=URLEncoder.encode("北京","UTF-8");

//        System.err.println("Get:"+HttpUtil.httpGetClient("http://v.juhe.cn/weather/index?key=819bd521a100686c112ed92bd696635c&cityname="+city));
//        Map<String,String> param=new HashMap<>();
//        param.put("key","a38d598021e48c15237a1a75f1666d72");
//        System.err.println("Post:"+HttpUtil.httpPostClient("http://apis.juhe.cn/lottery/types",param));
        //下载资源
        byte[] arr=HttpUtil.download("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1562321451&di=74417bb55fef3fc04b760092567a3445&src=http://ku.90sjimg.com/element_origin_min_pic/18/05/02/2f99be5b5960e98ca11d9c60c02dd926.jpg!/fwfh/804x509/quality/90/unsharp/true/compress/true");
        FileOutputStream fos=new FileOutputStream("hello.jpg");
        fos.write(arr);
        fos.flush();
        fos.close();
    }
}
