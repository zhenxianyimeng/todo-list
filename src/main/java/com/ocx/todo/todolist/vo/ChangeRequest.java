package com.ocx.todo.todolist.vo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author zjb
 * @date 2018/3/25.
 */
public class ChangeRequest {
    private List<Number> ids;

    private Integer status;

    public List<Number> getIds() {
        return ids;
    }

    public void setIds(List<Number> ids) {
        this.ids = ids;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
