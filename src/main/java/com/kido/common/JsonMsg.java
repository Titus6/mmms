package com.kido.common;

import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSONObject;
/**
 * Created by lzflovechh on 2017/4/22.
 *
 * json数据返回
 */
public class JsonMsg {

    /**
     * 成功
     */
    public static int CODE_SUCCESS = 0;
    /**失败*/
    public static int CODE_ERROR = -1;

    private int messageCount;
    private String msg;
    private int code;
    private boolean success;
    private Object data;
    private Integer appid;
    private Integer adId;

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

	public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 成功
     * @param msg
     * @return
     */
    public static JsonMsg OK(String msg)
    {
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setCode(CODE_SUCCESS);
        jsonMsg.setMsg(msg);
        jsonMsg.setSuccess(true);
        return jsonMsg;
    }

    public static JsonMsg OK(String msg, Object data)
    {
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setMsg(msg);
        jsonMsg.setCode(CODE_SUCCESS);
        jsonMsg.setData(data);
        jsonMsg.setSuccess(true);
        return jsonMsg;
    }

    public static JsonMsg OK(int code, String msg, Object data)
    {
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setMsg(msg);
        jsonMsg.setData(data);
        jsonMsg.setCode(code);
        jsonMsg.setSuccess(true);
        return jsonMsg;
    }
    
    public static JsonMsg OK(int messageCount, Object data,Integer appid)
    {
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setMessageCount(messageCount);
        jsonMsg.setData(data);
        jsonMsg.setAppid(appid);
        jsonMsg.setSuccess(true);
        return jsonMsg;
    }


    public static JsonMsg ERROR(String msg)
    {
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setSuccess(false);
        jsonMsg.setCode(CODE_ERROR);
        jsonMsg.setMsg(msg);
        return jsonMsg;
    }

    public static JsonMsg ERROR(String msg, Object data)
    {
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setSuccess(false);
        jsonMsg.setMsg(msg);
        jsonMsg.setData(data);
        jsonMsg.setCode(CODE_ERROR);
        return jsonMsg;
    }

    public static JsonMsg ERROR(int code, String msg, Object data)
    {
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setSuccess(false);
        jsonMsg.setMsg(msg);
        jsonMsg.setCode(code);
        jsonMsg.setData(data);

        return jsonMsg;
    }

}