package com.alitbit.sizeDesign.service.impl;

import com.alitbit.sizeDesign.bean.CustomerInfo;
import com.alitbit.sizeDesign.service.CustomerInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerInfoServiceImplTest {

    @Autowired
    private CustomerInfoService customerInfoService;

    @Test
    public void save() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setPhone("18829534050");
        customerInfo.setHeight(new BigDecimal(172.5));
        customerInfo.setNeckKnee(new BigDecimal(172.5));
        customerInfo.setShoulderSleeve(new BigDecimal(172.5));
        customerInfo.setChest(new BigDecimal(172.5));
        customerInfo.setWaist(new BigDecimal(172.5));
        customerInfo.setAss(new BigDecimal(172.5));
        customerInfo.setSleeveFat(new BigDecimal(172.5));
        CustomerInfo saveResult = customerInfoService.save(customerInfo);
        System.out.println(saveResult);
    }
}