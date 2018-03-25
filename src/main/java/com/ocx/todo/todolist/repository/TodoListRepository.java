package com.ocx.todo.todolist.repository;

import com.ocx.todo.todolist.model.TodoList;
import com.sun.tools.javac.comp.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author zjb
 * @date 2018/3/24.
 */
public interface TodoListRepository extends JpaRepository<TodoList, Long>{
    List<TodoList> findAllByStatusAndDeletedOrderByGmtCreateDesc(Integer status, Integer deleted);

    List<TodoList> findAllByDeletedOrderByGmtCreateDesc(Integer deleted);

    List<TodoList> findAllByIdAndDeleted(Long id, Integer deleted);

    @Modifying
    @Query("update TodoList o set o.status = :status where o.id in :ids and o.deleted = 0")
    int updateStatus(@Param("ids")List<Long> ids, @Param("status") Integer status);

    @Modifying
    @Query("update TodoList o set o.deleted =1 where o.id =:id")
    int deletedById(@Param("id")Long id);

}
