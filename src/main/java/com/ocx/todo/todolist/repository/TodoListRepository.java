package com.ocx.todo.todolist.repository;

import com.ocx.todo.todolist.model.TodoList;
import com.sun.tools.javac.comp.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zjb
 * @date 2018/3/24.
 */
public interface TodoListRepository extends JpaRepository<TodoList, Long>{
    List<TodoList> findAllByStatusAndDeletedOrderByGmtCreate(Integer status, Integer deleted);

    List<TodoList> findAllByDeletedOrderByGmtCreate(Integer deleted);
}
