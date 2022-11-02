package cc.vulpecula.domainbackend.servicer.impl;

import cc.vulpecula.domainbackend.classhome.LocalRemoteUpdate;
import cc.vulpecula.domainbackend.classhome.TodoItem;
import cc.vulpecula.domainbackend.mapper.LocalRemoteUpdateMapper;
import cc.vulpecula.domainbackend.mapper.TodoItemMapper;
import cc.vulpecula.domainbackend.servicer.TodoItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl extends ServiceImpl<TodoItemMapper, TodoItem> implements TodoItemService {

    @Autowired
    private TodoItemMapper todoItemMapper;
    @Autowired
    private LocalRemoteUpdateMapper localRemoteUpdateMapper;

//    public boolean localUpdate(String userId){
//        QueryWrapper<LocalRemoteUpdate> queryWrapper= new QueryWrapper<>();
//        queryWrapper.eq("user_id",userId);
//        LocalRemoteUpdate localRemoteUpdate = localRemoteUpdateMapper.selectOne(queryWrapper);
//        localRemoteUpdate.setLocalUpdate((localRemoteUpdate.getLocalUpdate() + 1) % 2);
//        return localRemoteUpdateMapper.update(localRemoteUpdate,queryWrapper) > 0;
//    }

    //返回值： 1。成功 0.失败
    public int localSaveAsRemote(TodoItem item){
        QueryWrapper<TodoItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", item.getUserId());
        queryWrapper.eq("item_id", item.getItemId());
        if(todoItemMapper.update(item, queryWrapper) > 0) return 1;
        else return 0;
    }

    //返回值 1.成功 0.失败
    public int RemotePublish(TodoItem item){
        if(todoItemMapper.insert(item) > 0) return 1;
        else return 0;
    }

    public int localHasSaved(String userId, int itemId){
        QueryWrapper<TodoItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("item_id", itemId);
        TodoItem todoItem = new TodoItem();
        todoItem.setUpdate(false);
        if(todoItemMapper.update(todoItem, queryWrapper) > 0) return 1;
        else return 0;
    }
}
