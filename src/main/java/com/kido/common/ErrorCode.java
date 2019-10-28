package com.kido.common;

/**
 * 定义错误返回code
 * 错误code从40001开始
 * 正确code为0
 */
public class ErrorCode {

    /** 正确返回 */
    public static int SUCCESS = 0;

    /** 请求超时 */
    public static int ERROR_TIMEOUR = 40001;

    /** 网络异常 */
    public static int ERROR_NETWORK = 40002;

    /** 权限不足 */
    public static int ERROR_PERMISSION_DENIED = 40003;

    /**  未登陆 */
    public static int ERROR_NOTLOGIN = 40004;

    /** 操作失败 */
    public static int ERROR_FAIL = 40005;
    /** 密码错误 **/
    public static int ERROR_PASSERROR = 40006;
    /** 账号锁定 **/
    public static int ERROR_ACCOUNTLOCKED = 40007;
    /** 系统错误 **/
    public static int ERROR_SYSTEMERROR = 40008;

    /** 参数不全 **/
    public static int ERROR_PARAMETERS = 40009;

}
