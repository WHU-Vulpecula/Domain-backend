package cc.vulpecula.domainbackend.servicer.impl;

import cc.vulpecula.domainbackend.classhome.CircleUserRela;
import cc.vulpecula.domainbackend.mapper.CircleMapper;
import cc.vulpecula.domainbackend.servicer.CircleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleServiceImpl extends ServiceImpl<CircleMapper, CircleUserRela> implements CircleService {
    @Autowired
    private CircleMapper circleMapper;

    public List<CircleUserRela> getUsersByCircleID(int id){
        QueryWrapper<CircleUserRela> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        queryWrapper.select("user_name");
        return circleMapper.selectList(queryWrapper);
    }
}
