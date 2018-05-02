package com.cf.bbackend.utils;

import com.cf.bbackend.vo.ResultVO;

/**
 * 返回前台文章数据
 */
public class ResultVOUtils {

    public static ResultVO success(Object object,int count){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCount(count);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return success();
    }

    public static ResultVO error(Integer code,String msg,Integer count){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setCount(count);
        return resultVO;
    }
}
