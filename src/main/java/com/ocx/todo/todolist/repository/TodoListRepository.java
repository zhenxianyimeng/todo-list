package com.ocx.todo.todolist.repository;

import com.ocx.todo.todolist.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zjb
 * @date 2018/3/24.
 */
public interface TodoListRepository extends JpaRepository<TodoList, Long> {


}
