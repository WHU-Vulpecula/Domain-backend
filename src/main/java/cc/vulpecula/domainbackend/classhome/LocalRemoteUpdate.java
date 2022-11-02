package cc.vulpecula.domainbackend.classhome;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("local_remote_update")
public class LocalRemoteUpdate {
    String userId;
    int localUpdate;
    int remoteUpdate;
}
