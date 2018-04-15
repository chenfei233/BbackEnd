package com.cf.bbackend.utils;

import com.cf.bbackend.vo.ResultVO;

public class ResultVOUtils {

    public static ResultVO success(Object object,int count){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCount(count);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
