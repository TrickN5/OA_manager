package com.oa.manage.controller;


import com.oa.commons.PaymentData;
import com.oa.manage.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @RequestMapping("/getPayDatas")
    @ResponseBody
    public String getPayDatas(){
        /*
        需要的数据结构:
          [
            { value: 1048, name: '出差补贴' },
            { value: 735, name: 'Direct' },
            { value: 580, name: 'Email' },
            { value: 484, name: 'Union Ads' },
            { value: 300, name: 'Video Ads' }
          ]
           取到的数据
          [
          PaymentData{expid='4', totalamout='1200.00'},
          PaymentData{expid='3', totalamout='5000.00'},
           PaymentData{expid='2', totalamout='4000.00'},
           PaymentData{expid='1', totalamout='6500.00'},
           PaymentData{expid='5', totalamout='8000.00'}
           ]
         */
        List<PaymentData> payments = paymentService.getPayments();
        System.out.println(payments);
        String datas = "[\n" +
                "            { value: "+payments.get(0).getTotalamout()+", name: '"+change(payments.get(0).getExpid())+"' },\n" +
                "            { value: "+payments.get(1).getTotalamout()+", name: '"+change(payments.get(1).getExpid())+"' },\n" +
                "            { value: "+payments.get(2).getTotalamout()+", name: '"+change(payments.get(2).getExpid())+"' },\n" +
                "            { value: "+payments.get(3).getTotalamout()+", name: '"+change(payments.get(3).getExpid())+"' },\n" +
                "            { value: "+payments.get(4).getTotalamout()+", name: '"+change(payments.get(4).getExpid())+"' }\n" +
                "          ]";
        return datas;
    }

    public String change(String expid){
        String result=null;
        switch (expid){
            case "1":
                result= "通信费用";
                break;
            case "2":
                result= "办公室耗材";
                break;
            case "3":
                result= "住宿费用";
                break;
            case "4":
                result= "房租水电";
                break;
            case "5":
                result= "其他";
                break;

        }
        return result;
    }
}