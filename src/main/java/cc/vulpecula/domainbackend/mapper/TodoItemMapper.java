package cc.vulpecula.domainbackend.mapper;

import cc.vulpecula.domainbackend.classhome.TodoItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoItemMapper extends BaseMapper<TodoItem> {
}
