package cc.vulpecula.domainbackend.classhome;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("circle_user_relation")
public class CircleUserRela {
    private String userName;
    private String circleName;
    private Integer id;
}
