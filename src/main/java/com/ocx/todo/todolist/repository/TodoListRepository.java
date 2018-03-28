package com.ocx.todo.todolist.repository;

import com.ocx.todo.todolist.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query("update TodoList o set o.note = :note where o.id = :id and o.deleted = 0")
    int updateNote(@Param("id")Long id, @Param("note") String note);

    @Modifying
    @Query("update TodoList o set o.deleted =1 where o.id in :ids")
    int deletedByIds(@Param("ids")List<Long> ids);

    @Query(value = "select * from t_todo o where o.deleted =0 and o.note like %:text%", nativeQuery = true)
    List<TodoList> searchByText(@Param("text") String text);

}
