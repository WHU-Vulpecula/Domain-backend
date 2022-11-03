package cc.vulpecula.domainbackend.classhome;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_todoitem")
public class TodoItem {
    String publisherId;
    String userId;
    String circleId;
    String title;
    int startDate;
    int endDate;
    int itemId;
    String detail;
    int status;
    boolean isPinned;
    boolean isUpdate;
}
