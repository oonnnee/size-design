package com.alitbit.sizeDesign.handler;

import com.alitbit.sizeDesign.enums.ResultEnum;
import com.alitbit.sizeDesign.exception.Exceptions;
import com.alitbit.sizeDesign.util.ResultVOUtil;
import com.alitbit.sizeDesign.vo.ResultVO;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exceptions.class)
    @ResponseBody
    public ResultVO handleException(Exceptions e){
        ResultVO resultVO;

        if (e.getCode() == ResultEnum.ERROR.getCode()){
            resultVO = ResultVOUtil.error(e.getMessage());
        }else if(e.getCode() == ResultEnum.NO_LOGIN.getCode()) {
            resultVO = ResultVOUtil.noLogin();
        }else {
            resultVO = ResultVOUtil.error("内部错误");
        }

        return resultVO;
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultVO handleBindException(BindException e){
        return ResultVOUtil.error(e.getAllErrors().get(0).getDefaultMessage());
    }

}
