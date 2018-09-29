package com.alitbit.sizeDesign.controller;


import com.alitbit.sizeDesign.bean.CustomerInfo;
import com.alitbit.sizeDesign.dto.PageChunk;
import com.alitbit.sizeDesign.form.CustomerInfoSaveForm;
import com.alitbit.sizeDesign.service.CustomerInfoService;
import com.alitbit.sizeDesign.util.ResultVOUtil;
import com.alitbit.sizeDesign.util.TransformUtil;
import com.alitbit.sizeDesign.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/customer-info")
public class CustomerInfoController {

    @Autowired
    private CustomerInfoService customerInfoService;

    @PostMapping("/submit")
    public ResultVO submit(HttpSession httpSession, @Valid CustomerInfoSaveForm customerInfoSaveForm){

        Object phone = httpSession.getAttribute("phone");
//        if (phone == null){
////            return ResultVOUtil.noLogin();
////        }

        CustomerInfo saveResult = customerInfoService.save(TransformUtil.saveFormToCustomerInfo(customerInfoSaveForm));

        return ResultVOUtil.success(saveResult);
    }

}