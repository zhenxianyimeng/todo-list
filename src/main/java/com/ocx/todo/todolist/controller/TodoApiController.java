package com.ocx.todo.todolist.controller;

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
            List<TodoList> list = new ArrayList<>();
            if(status == null){

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultVo.failed();
    }

    @ApiImplicitParam(name = "id", value = "todo详情id", required = true, dataType = "Long",paramType = "query")
    @ApiOperation(value = "根据id获取详情")
    @GetMapping("get")
    public ResultVo getById(@RequestParam Number id){
        System.out.println(id);
        return null;
    }

    @ApiImplicitParam(name = "id", value = "todo详情id", required = true, dataType = "Long",paramType = "query")
    @ApiOperation(value = "根据id删除todo详情")
    @GetMapping("delete")
    public ResultVo deleteById(@RequestParam Number id){

        return ResultVo.succeed();
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "request", value = "id列表和修改状态", required = true, dataType = "ChangeRequest"),
    })
    @ApiOperation(value = "根据id列表和status,修改值")
    @PostMapping("change")
    public ResultVo changeStateById(@RequestBody ChangeRequest request){

        return ResultVo.succeed();
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "q", value = "查询语句", required = true, dataType = "String",paramType = "query"),
    })
    @ApiOperation(value = "根据q的值搜索todo text")
    @GetMapping("search")
    public ResultVo searchList(@RequestParam String q){

        return ResultVo.succeed();
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
