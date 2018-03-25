package com.ocx.todo.todolist.vo;

import com.ocx.todo.todolist.constant.BusinessCode;

import java.io.Serializable;

/**
 * @author zjb
 * @date 2018/3/24.
 */
public class ResultVo<T> implements Serializable{

    private static final long serialVersionUID = -4149250470728491240L;

    private Integer code;

    private String message;

    private T data;

    public static ResultVo succeed(){
        return new ResultVo(BusinessCode.SUCCESS.code());
    }

    public ResultVo() {
    }

    public ResultVo(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
