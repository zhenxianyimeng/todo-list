package com.ocx.todo.todolist.service;

import com.ocx.todo.todolist.model.TodoList;
import com.ocx.todo.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjb
 * @date 2018/3/25.
 */
@Service
class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoListRepository todoDao;

    @Override
    public List<TodoList> listAllOrderByTime() {
        return todoDao.findAllByDeletedOrderByGmtCreate(0);
    }

    @Override
    public List<TodoList> listByStatusOrderByTime(Integer status) {
        return todoDao.findAllByStatusAndDeletedOrderByGmtCreate(status, 0);
    }

    @Override
    public Boolean add(String text) {
        TodoList todoList = new TodoList();
        todoList.setNote(text);
        todoList.setStatus(0);
        todoList.setDeleted(0);
        TodoList result = todoDao.save(todoList);
        return result != null;
    }
}
