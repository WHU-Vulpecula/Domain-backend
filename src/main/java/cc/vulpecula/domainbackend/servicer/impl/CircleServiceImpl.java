package cc.vulpecula.domainbackend.servicer.impl;

import cc.vulpecula.domainbackend.classhome.CircleUserRela;
import cc.vulpecula.domainbackend.mapper.CircleMapper;
import cc.vulpecula.domainbackend.servicer.CircleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.handlers.GsonTypeHandler;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CircleServiceImpl extends ServiceImpl<CircleMapper, CircleUserRela> implements CircleService {
    @Autowired
    private CircleMapper circleMapper;

    public List<CircleUserRela> getUserIDsByCircleID(int id){
        QueryWrapper<CircleUserRela> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("circle_id", id);
        queryWrapper.select("user_id");
        return circleMapper.selectList(queryWrapper);
    }

    @Override
    public List<CircleUserRela> getCircleIDsByUserID(int id) {
        QueryWrapper<CircleUserRela> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        queryWrapper.select("circle_id");
        return circleMapper.selectList(queryWrapper);
    }

    public boolean isOwner(String userId, String circleId){
        QueryWrapper<CircleUserRela> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("circle_id",circleId);
        CircleUserRela circleUserRela = circleMapper.selectOne(queryWrapper);
        if(circleUserRela == null || circleUserRela.getIsOwner() == 0) return false;
        return true;
    }

}
