package com.ocx.todo.todolist.controller;

import com.ocx.todo.todolist.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjb
 * @date 2018/3/24.
 */
@RestController
@RequestMapping("api")
public class TodoApiController {

    @ApiOperation(value="获取todo列表", notes="获取所有的todo列表")
    @RequestMapping(value={"list"}, method= RequestMethod.GET)
    public ResultVo getAll(){
        return new ResultVo();
    }
}
