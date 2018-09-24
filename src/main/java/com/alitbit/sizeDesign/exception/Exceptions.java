package com.alitbit.sizeDesign.exception;

import com.alitbit.sizeDesign.enums.ResultEnum;
import lombok.Getter;

@Getter
public class Exceptions extends RuntimeException {

    private Integer code;

    public Exceptions(Integer code, String msg){
        super(msg);
        this.code = code;
    }

    public Exceptions(String msg){
        super(msg);
        this.code = ResultEnum.ERROR.getCode();
    }
}
