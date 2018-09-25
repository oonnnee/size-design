package com.alitbit.sizeDesign.controller;

import com.alitbit.sizeDesign.util.RandomUtil;
import com.alitbit.sizeDesign.util.Sms;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/get/{number}")
    public String getSms(@PathVariable String number) throws ClientException {
        String SmsCode = RandomUtil.getRandom();
        redisTemplate.opsForValue().set(number, SmsCode, 3*60, TimeUnit.SECONDS);
        String msg = Sms.sendSms(number,SmsCode).getCode();
        return msg;
    }

    @RequestMapping("/ok/{number}/{sms}")
    public String authSms(@PathVariable String number, @PathVariable String sms, HttpSession httpSession) {
        String sms2 = redisTemplate.opsForValue().get(number);
        boolean returnStr = false;
        if(sms2.equals(sms)){
            returnStr = true;
            httpSession.setAttribute("phone", number);
        }
        return returnStr + "";
    }
}
