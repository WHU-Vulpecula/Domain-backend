package cc.vulpecula.domainbackend.classhome;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_data")
public class User {
    private String userName;
    private String password;
    private String email;
    @TableId(type= IdType.AUTO)
    private Integer id;
}
