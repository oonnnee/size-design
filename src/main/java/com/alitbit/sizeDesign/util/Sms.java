package com.alitbit.sizeDesign.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class Sms {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;



    public static SendSmsResponse sendSms(String number,String code) throws ClientException {

        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //云通信产品-短信API服务产品名称（短信产品名固定，无需修改）
        final String product = "Dysmsapi";
        //云通信产品-短信API服务产品域名（接口地址固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";

        final String accessKeyId = "LTAIxRLECNQ4u6Od";//自己的AccessKeyId
        final String accessKeySecret = "C4x9SzoBXrFse7iew2RKEpKjsyD9Ly";//自己的AccessKeySecret

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);

        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //必填-号码
        request.setPhoneNumbers(number);//手机号
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName("JUSTALIT");
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_144520205");//短信模板号
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处              的值为
        request.setTemplateParam("{code:"+ code + "}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
//请求成功
        }
        return sendSmsResponse;
    }

}
