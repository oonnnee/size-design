package com.alitbit.sizeDesign.service.impl;

import com.alitbit.sizeDesign.bean.CustomerInfo;
import com.alitbit.sizeDesign.dao.CustomerInfoDao;
import com.alitbit.sizeDesign.dto.PageChunk;
import com.alitbit.sizeDesign.service.CustomerInfoService;
import com.alitbit.sizeDesign.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

    @Autowired
    private CustomerInfoDao customerInfoDao;

    @Override
    public CustomerInfo save(CustomerInfo customerInfo) {
        CustomerInfo before = null;
        try{
            before = customerInfoDao.findById(customerInfo.getPhone()).get();
        }catch (NoSuchElementException e){
        }

        if (before != null){
            customerInfo.setBigSize(before.getBigSize());
        }

        CustomerInfo saveResult = customerInfoDao.save(customerInfo);

        return saveResult;
    }

    @Override
    public PageChunk<CustomerInfo> findPage(Integer page, Integer size) {
        Pageable pageable = PageUtil.getPageable(page, size);

        Page<CustomerInfo> customerInfoPage = customerInfoDao.findAll(pageable);

        return PageUtil.getPageChunk(customerInfoPage);
    }

    @Override
    public CustomerInfo find(String phone) {
        CustomerInfo customerInfo = null;
        try{
            customerInfo = customerInfoDao.findById(phone).get();
        }catch (NoSuchElementException e){
        }

        return customerInfo;
    }


}
