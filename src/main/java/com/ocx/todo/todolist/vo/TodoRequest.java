package com.ocx.todo.todolist.vo;

/**
 * @author zjb
 * @date 2018/3/27.
 */
public class TodoRequest {
    private Long id;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "TodoRequest{" +
                "id=" + id +
                ", note='" + note + '\'' +
                '}';
    }
}
