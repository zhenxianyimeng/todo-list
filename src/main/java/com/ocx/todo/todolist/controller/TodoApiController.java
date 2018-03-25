package com.ocx.todo.todolist.controller;

import com.ocx.todo.todolist.constant.BusinessCode;
import com.ocx.todo.todolist.model.TodoList;
import com.ocx.todo.todolist.service.TodoService;
import com.ocx.todo.todolist.vo.ChangeRequest;
import com.ocx.todo.todolist.vo.ResultVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zjb
 * @date 2018/3/24.
 */
@RestController
@RequestMapping("api")
public class TodoApiController {

    @Autowired
    private TodoService todoService;

    @ApiOperation(value="获取todo列表", notes="获取所有的todo列表,status可选参数")
    @ApiImplicitParam(name = "status", value = "状态", required = false, dataType = "Integer",paramType = "query")
    @GetMapping("list")
    public ResultVo getAll(@RequestParam(required = false) Integer status){
        try {
            List<TodoList> list;
            if(status == null){
                list = todoService.listAllOrderByTime();
            }else {
                list = todoService.listByStatusOrderByTime(status);
            }
            ResultVo<List<TodoList>> resultVo = new ResultVo<>(BusinessCode.SUCCESS.code(), BusinessCode.SUCCESS.msg());
            resultVo.setData(list);
            return resultVo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultVo.failed();
    }

    @ApiImplicitParam(name = "id", value = "todo详情id", required = true, dataType = "Long",paramType = "query")
    @ApiOperation(value = "根据id获取详情")
    @GetMapping("get")
    public ResultVo getById(@RequestParam Number id){
        try {
            Long longId = id.longValue();
            TodoList to = todoService.getById(longId);
            if(to != null){
                ResultVo<List<TodoList>> resultVo = new ResultVo(BusinessCode.SUCCESS.code(), BusinessCode.SUCCESS.msg());
                List<TodoList> list = new ArrayList<>();
                list.add(to);
                resultVo.setData(list);
                return resultVo;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultVo.failed();
    }

    @ApiImplicitParam(name = "id", value = "todo详情id", required = true, dataType = "Long",paramType = "query")
    @ApiOperation(value = "根据id删除todo详情")
    @GetMapping("delete")
    public ResultVo deleteById(@RequestParam Number id){
        Long todoId = id.longValue();
        try {
            boolean success = todoService.deletedById(todoId);
            if(success){
                return ResultVo.succeed();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultVo.failed();
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "request", value = "id列表和修改状态", required = true, dataType = "ChangeRequest"),
    })
    @ApiOperation(value = "根据id列表和status,修改值")
    @PostMapping("change")
    public ResultVo changeState(@RequestBody ChangeRequest request){
        try {
            List<Long> ids = request.getIds().stream().map(id->id.longValue()).collect(Collectors.toList());
            Integer status = request.getStatus();
            boolean success = todoService.updateStatusById(ids, status);
            if(success){
                return ResultVo.succeed();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultVo.failed();
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "q", value = "查询语句", required = true, dataType = "String",paramType = "query"),
    })
    @ApiOperation(value = "根据q的值搜索todo text")
    @GetMapping("search")
    public ResultVo searchList(@RequestParam String q){
        try {
            List<TodoList> list = todoService.searchByText(q);
            ResultVo<List<TodoList>> resultVo = new ResultVo<>(BusinessCode.SUCCESS.code(), BusinessCode.SUCCESS.msg());
            resultVo.setData(list);
            return resultVo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultVo.failed();
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "request", value = "id列表和修改状态", required = true, dataType = "HashMap"),
    })
    @ApiOperation(value = "新增todo列表")
    @PostMapping("add")
    public ResultVo add(@RequestBody Map<String,String> request){
        try {
            String note = request.get("text");
            boolean success = todoService.add(note);
            if(success){
                return ResultVo.succeed();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultVo.failed();
    }


}
