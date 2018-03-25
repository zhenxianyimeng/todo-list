package com.ocx.todo.todolist.constant;

/**
 * @author zjb
 * @date 2018/3/25.
 */
public enum  BusinessCode {
    SUCCESS(0,"");

    private Integer code;

    private String desc;

    BusinessCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer code() {
        return code;
    }

    public String msg(){
        return desc;
    }
}
