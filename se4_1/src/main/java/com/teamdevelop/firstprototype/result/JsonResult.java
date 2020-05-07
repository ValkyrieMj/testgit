package com.teamdevelop.firstprototype.result;

import java.io.Serializable;

/**
 * @author : JingYao Deng
 * @classname: JsonResult
 * @date : 2019/11/5 19:11
 * @Description: 统一返回结果的格式，不论请求是成功或者失败都是一样的格式，只是内容上加以区别
 */


public class JsonResult implements Serializable
{
    private Integer code;     // 状态码，0表示成功，1表示处理中，-1表示失败
    private String msg;       // 返回状态的描述
    private Object data;      // 数据

    /**无参的构造函数*/
    public JsonResult(){}

    /**有参的构造*/
    public JsonResult( Integer code, String msg, Object data )
    {
        this.code = code;
        this.msg = msg;
        this.data =data;
    }

    /**成功，传入数据*/
    public static JsonResult buildSuccess()
    {
        return new JsonResult( 0, null, null );
    }

    /**成功，传入数据*/
    public static JsonResult buildSuccess( Object data )
    {
        return new JsonResult( 0, null, data );
    }

    /**成功，传入数据，及描述信息*/
    public static JsonResult buildSuccess( String msg, Object data )
    {
        return new JsonResult(0, msg, data );
    }

    /**成功，传入数据，及状态码*/
    public static JsonResult buildSuccess( Integer code, Object data )
    {
        return new JsonResult( code, null, data );
    }

    /**失败，传入描述信息*/
    public static JsonResult buildError( String msg )
    {
        return new JsonResult( -1, msg, null );
    }

    /**失败，传入状态码*/
    public static JsonResult buildError()
    {
        return new JsonResult( -1, null, null  );
    }

    /**失败，传入描述信息*/
    public static JsonResult buildError( Integer code, String msg )
    {
        return  new JsonResult( code, msg, null );
    }


    /**默认的getter和setter*/
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**设置最终的返回格式*/
    @Override
    public String toString()
    {
        return "JsonData [code=" + code + ",data" + data + ",msg" + msg + "]";
    }
}
