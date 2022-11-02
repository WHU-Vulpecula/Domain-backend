package cc.vulpecula.domainbackend.servicer;

import cc.vulpecula.domainbackend.classhome.CircleUserRela;
import cc.vulpecula.domainbackend.classhome.User;
import cc.vulpecula.domainbackend.mapper.CircleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CircleService extends IService<CircleUserRela> {

    List<CircleUserRela> getUserIDsByCircleID(int id);
    List<CircleUserRela> getCircleIDsByUserID(int id);
}
