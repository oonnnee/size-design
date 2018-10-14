package com.alitbit.sizeDesign.service;

import com.alitbit.sizeDesign.bean.CustomerInfo;
import com.alitbit.sizeDesign.dto.PageChunk;
import org.springframework.data.domain.Page;

public interface CustomerInfoService {

    CustomerInfo save(CustomerInfo customerInfo);
    PageChunk<CustomerInfo> findPage(Integer page, Integer size);
    CustomerInfo find(String phone);

}
