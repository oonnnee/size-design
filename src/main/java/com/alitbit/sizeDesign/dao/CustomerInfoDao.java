package com.alitbit.sizeDesign.dao;

import com.alitbit.sizeDesign.bean.CustomerInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoDao extends JpaRepository<CustomerInfo, String> {


}
