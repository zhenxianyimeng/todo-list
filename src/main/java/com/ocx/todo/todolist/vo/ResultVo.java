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

    private Long activeCount;

    private Long completedCount;

    private T data;

    public static ResultVo succeed(){
        return new ResultVo(BusinessCode.SUCCESS.code());
    }

    public static ResultVo failed(){
        return new ResultVo(BusinessCode.FAILED.code(), BusinessCode.FAILED.msg());
    }

    public ResultVo() {
    }

    public ResultVo(Integer code, String message) {
        this.code = code;
        this.message = message;
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

    public Long getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(Long activeCount) {
        this.activeCount = activeCount;
    }

    public Long getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Long completedCount) {
        this.completedCount = completedCount;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", activeCount=" + activeCount +
                ", completedCount=" + completedCount +
                ", data=" + data +
                '}';
    }
}
