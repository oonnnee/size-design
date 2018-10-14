package com.alitbit.sizeDesign.util;

import com.alitbit.sizeDesign.enums.ResultEnum;
import com.alitbit.sizeDesign.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(){
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"成功", null);
    }

    public static ResultVO success(Object data){
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"成功", data);
    }

    public static ResultVO error(String msg){
        return new ResultVO(ResultEnum.ERROR.getCode(), "失败", msg);
    }

    public static ResultVO noLogin(){
        return new ResultVO(ResultEnum.NO_LOGIN.getCode(), ResultEnum.NO_LOGIN.getNote(), null);
    }

}
