package com.alitbit.sizeDesign.util;

import com.alitbit.sizeDesign.bean.CustomerInfo;
import com.alitbit.sizeDesign.form.CustomerInfoSaveForm;
import org.springframework.beans.BeanUtils;

public class TransformUtil {

    public static CustomerInfo saveFormToCustomerInfo(CustomerInfoSaveForm customerInfoSaveForm){
        CustomerInfo customerInfo = new CustomerInfo();
        BeanUtils.copyProperties(customerInfoSaveForm, customerInfo);
        return customerInfo;
    }
}
