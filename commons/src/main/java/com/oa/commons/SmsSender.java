package com.oa.commons;


import org.springframework.stereotype.Component;

import java.util.Random;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 发送短信
 */
@Component
public class SmsSender {
    /**
     * @param phone 发送短信到目标手机号
     * @return 返回发送到手机号的六位随机码，给调用者使用
     * @throws Exception
     */
    public static String sendSms(String phone) throws Exception {
        String code = getCode();
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("https://utf8api.smschinese.cn/");
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
        NameValuePair[] data = {new NameValuePair("Uid", "@TrickN"), new NameValuePair("Key", "93406458D76E8C061E508AAFD80094B5"), new NameValuePair("smsMob", phone), new NameValuePair("smsText", code)};
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode); //HTTP状态码
        for (Header h : headers) {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
        /*
        打印返回消息状态
        大于0提交成功短信发送数量
         */
        System.out.println("打印返回消息状态" + result);  //打印返回消息状态

        post.releaseConnection();
        return code;
    }

    //封装一个获取6位随机数的方法
    public static String getCode() {
        String num = "";
        while (num.length() < 6) {
            Random r = new Random();
            int i = r.nextInt(10);//产生一个0-9之间的随机数
            num += i;
        }
        return num;
    }
}
