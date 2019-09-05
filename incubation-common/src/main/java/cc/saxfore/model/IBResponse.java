package cc.saxfore.model;

import java.io.Serializable;

/**
 * 项目名称：incubation
 * 类 名 称：IBResponse
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:21 PM
 * 创 建 人：wangjiang
 */
public class IBResponse<T> implements Serializable {

    protected int code;
    protected String msg;
    protected T data;

    public IBResponse() {

    }

    public IBResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public IBResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public IBResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
