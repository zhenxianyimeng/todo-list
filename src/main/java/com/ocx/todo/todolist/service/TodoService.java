package com.ocx.todo.todolist.service;

import com.ocx.todo.todolist.model.TodoList;

import java.util.List;

/**
 * @author zjb
 * @date 2018/3/25.
 */
public interface TodoService {
    List<TodoList> listAllOrderByTime();

    List<TodoList> listByStatusOrderByTime(Integer status);

    Boolean add(String text);
}
