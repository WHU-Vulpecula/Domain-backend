package cc.vulpecula.domainbackend.controller;

import cc.vulpecula.domainbackend.classhome.TodoItem;
import cc.vulpecula.domainbackend.servicer.CircleService;
import cc.vulpecula.domainbackend.servicer.TodoItemService;
import cc.vulpecula.domainbackend.servicer.impl.CircleServiceImpl;
import cc.vulpecula.domainbackend.servicer.impl.TodoItemServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoitem")
public class TodoItemController {

    @Autowired
    private TodoItemServiceImpl todoItemService;
    @Autowired
    private CircleServiceImpl circleService;


    // 返回值：1.成功 2.无权限 0.意外失败
    @PostMapping("/add")
    int addItem(@RequestBody TodoItem item){
        if(!circleService.isOwner(item.getPublisherId(), item.getCircleId())) return 2;
        if(todoItemService.save(item)) return 1;
        return 0;
    }

    @PostMapping("/localSaveAsRemote")
    int localSaveAsRemote(@RequestBody TodoItem todoItem){
        return todoItemService.localSaveAsRemote(todoItem);
    }

    @GetMapping("pull/{userId}")
    List<TodoItem> localGetUpdate(@PathVariable String userId){
        QueryWrapper<TodoItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_update", true);
        List<TodoItem> res = todoItemService.list(queryWrapper);
        TodoItem todoItem = new TodoItem();
        todoItem.setUpdate(false);
        todoItemService.update(todoItem,queryWrapper);
        return res;
    }
}
