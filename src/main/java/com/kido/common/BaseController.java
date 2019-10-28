package com.kido.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

public class BaseController {

    /**
     * 生成JSON信息
     * @param result    是否成功
     * @param msg       提示信息
     * @param code      错误码
     * @param data      数据
     * @return
     */
    public JSONObject msg(boolean result, String msg, int code, Object data){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("success", result);
        jsonObject.put("msg", msg);
        jsonObject.put("code", code);
        jsonObject.put("data", data);

        return jsonObject;
    }

    /**
     * 返回成功的JSON信息
     * @param msg   提示信息
     * @param data  返回数据
     * @return
     */
    public JSONObject ok(String msg, Object data){
        return msg(true, msg, ErrorCode.SUCCESS, data);
    }

    /**
     * 只返回成功信息
     *
     * @param msg   提示信息
     * @return
     */
    public JSONObject ok(String msg){
        return ok(msg, null);
    }

    /**
     * 返回错误的JSON信息
     * @param msg       提示信息
     * @param code      返回码
     * @param data      数据
     * @return
     */
    public JSONObject error(String msg, int code, Object data){
        return msg(false, msg, code, data);
    }

    /**
     * 无返回的报错信息
     * @param msg       提示信息
     * @param code      返回码
     * @return
     */
    public JSONObject error(String msg, int code){
        return error(msg, code, null);
    }

    /**
     * 操作错误信息
     *
     * @param msg   提示信息
     * @param data  数据
     * @return
     */
    public JSONObject error(String msg, Object data){
        return error(msg, ErrorCode.ERROR_FAIL, data);
    }

    /**
     * 操作错误信息——只提示信息
     * @param msg   提示信息
     * @return
     */
    public JSONObject error(String msg){
        return error(msg, null);
    }

    /**
     * 通用报错信息
     * @return
     */
    public JSONObject error(){
        return error("网络异常，请稍后再试");
    }

    /**
     * 保存成功通用信息
     * @return
     */
    public JSONObject saveOk(){
        return ok("保存成功");
    }

    /**
     * 通用更新成功信息
     * @return
     */
    public JSONObject updateOk(){
        return ok("更新成功");
    }

    /**
     * 通用删除成功信息
     * @return
     */
    public  JSONObject deleteOk(){
        return ok("删除成功");
    }

    /**
     * 通用成功信息
     * @return
     */
    public JSONObject ok(){
        return ok("操作成功");
    }

    /**
     * 判断参数是否为null
     * @param params    参数，用英文逗号隔开
     * @param jsonObject
     * @return
     */
    public boolean notNull(String params, JSONObject jsonObject){
        boolean flag = true;
        if(StringUtils.isNotBlank(params)){
            String[] arr = params.split(",");
            for(String str : arr){
                if(null == jsonObject.get(str) ){
                    flag = false;
                    break;
                }
            }
        }
        return flag ;
    }
}
