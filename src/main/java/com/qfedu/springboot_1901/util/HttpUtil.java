package com.qfedu.springboot_1901.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/7/5 17:02
 */
public class HttpUtil {

    public static String httpGet(String u){
        HttpURLConnection urlConnection= null;
        BufferedReader bufferedReader=null;
        try {
            //1、创建url对象
            URL url=new URL(u);
            //2、获取连接对象
            urlConnection = (HttpURLConnection) url.openConnection();
            //3、请求设置  请求参数、请求方式 超时时间等
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            //4、连接服务器
            urlConnection.connect();
            //5、验证返回状态码
            if(urlConnection.getResponseCode()==200){
                //6、获取响应结果
                StringBuffer buffer=new StringBuffer();
                bufferedReader=new BufferedReader(new InputStreamReader(urlConnection
                        .getInputStream()));
                String m=null;
                while ((m=bufferedReader.readLine())!=null){
                    buffer.append(m);
                }

                return buffer.toString();
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
    public static String httpPost(String u,String param){
        HttpURLConnection urlConnection= null;
        BufferedReader bufferedReader=null;
        try {
            //1、创建url对象
            URL url=new URL(u);
            //2、获取连接对象
            urlConnection = (HttpURLConnection) url.openConnection();
            //3、请求设置  请求参数、请求方式 超时时间等
            urlConnection.setRequestMethod("POST");
            urlConnection.setConnectTimeout(5000);
            if(param!=null && param.length()>0) {
                //设置拥有输出流对象
                urlConnection.setDoOutput(true);
                //设置请求参数
                OutputStream os = urlConnection.getOutputStream();
                os.write(param.getBytes());
            }

            //4、连接服务器
            urlConnection.connect();
            //5、验证返回状态码
            if(urlConnection.getResponseCode()==200){
                //6、获取响应结果
                StringBuffer buffer=new StringBuffer();
                bufferedReader=new BufferedReader(new InputStreamReader(urlConnection
                        .getInputStream()));
                String m=null;
                while ((m=bufferedReader.readLine())!=null){
                    buffer.append(m);
                }

                return buffer.toString();
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
    public static String httpGetClient(String url){
        //1、创建请求对象
        HttpGet httpGet=new HttpGet(url);
        //2、创建客户端对象
        HttpClient httpClient=HttpClientBuilder.create().build();
        //3、执行请求
        HttpResponse httpResponse= null;
        try {
            httpResponse = httpClient.execute(httpGet);
            //4、验证请求结果
            if(httpResponse.getStatusLine().getStatusCode()==200){
                //5、获取请求结果
                HttpEntity httpEntity=httpResponse.getEntity();
                return EntityUtils.toString(httpEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String httpPostClient(String url,Map<String,String> param){
        //1、创建请求对象
        HttpPost httpPost=new HttpPost(url);
        //2、创建客户端对象
        HttpClient httpClient=HttpClientBuilder.create().build();
        HttpResponse httpResponse= null;
        try {
            //传递参数
            if(param!=null && param.size()>0){
                List<NameValuePair> list=new ArrayList<>();
                for(String k:param.keySet()){
                    list.add(new BasicNameValuePair(k,param.get(k)));
                }
                UrlEncodedFormEntity formEntity=new UrlEncodedFormEntity(list);
                httpPost.setEntity(formEntity);
                //时候json传参
//                StringEntity stringEntity=new StringEntity(param);
//                httpPost.setEntity(stringEntity);
            }
            //3、执行请求
            httpResponse = httpClient.execute(httpPost);
            //4、验证请求结果
            if(httpResponse.getStatusLine().getStatusCode()==200){
                //5、获取请求结果
                HttpEntity httpEntity=httpResponse.getEntity();
                return EntityUtils.toString(httpEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //下载资源
    public static byte[] download(String url){
        //1、创建请求对象
        HttpGet httpGet=new HttpGet(url);
        //2、创建客户端对象
        HttpClient httpClient=HttpClientBuilder.create().build();
        //3、执行请求
        HttpResponse httpResponse= null;
        try {
            httpResponse = httpClient.execute(httpGet);
            //4、验证请求结果
            if(httpResponse.getStatusLine().getStatusCode()==200){
                //5、获取请求结果
                HttpEntity httpEntity=httpResponse.getEntity();
                return EntityUtils.toByteArray(httpEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
