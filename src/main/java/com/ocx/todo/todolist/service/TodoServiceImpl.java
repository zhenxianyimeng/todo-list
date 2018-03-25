package com.ocx.todo.todolist.service;

import com.ocx.todo.todolist.model.TodoList;
import com.ocx.todo.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
        return todoDao.findAllByDeletedOrderByGmtCreateDesc(0);
    }

    @Override
    public List<TodoList> listByStatusOrderByTime(Integer status) {
        return todoDao.findAllByStatusAndDeletedOrderByGmtCreateDesc(status, 0);
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

    @Override
    @Transactional
    public Boolean updateStatusById(List<Long> ids, Integer status) {
        return todoDao.updateStatus(ids, status) > 0;
    }

    @Override
    @Transactional
    public Boolean deletedById(Long id) {
        return todoDao.deletedById(id) > 0;
    }

    @Override
    public TodoList getById(Long id) {
        List<TodoList> list = todoDao.findAllByIdAndDeleted(id, 0);
        if(!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }
        return null;
    }
}
