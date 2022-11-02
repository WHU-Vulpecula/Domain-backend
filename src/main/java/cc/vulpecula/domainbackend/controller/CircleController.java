package cc.vulpecula.domainbackend.controller;

import cc.vulpecula.domainbackend.classhome.CircleUserRela;
import cc.vulpecula.domainbackend.servicer.CircleService;
import cc.vulpecula.domainbackend.servicer.impl.CircleServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/circle")
public class CircleController {
    @Autowired
    private CircleServiceImpl circleService;

    @GetMapping("/getUserIDsByCircleID/{id}")
    public List<CircleUserRela> getUserIDsByCircleID(@PathVariable int id){
        return circleService.getUserIDsByCircleID(id);
    }

    @GetMapping("/getCircleIDsByUserID/{id}")
    public List<CircleUserRela> getCircleIDsByUserID(@PathVariable int id){
        return circleService.getCircleIDsByUserID(id);
    }

    @PostMapping("/add")
    public Boolean addCircleUserRelation(@RequestBody CircleUserRela circleUserRela){
        return circleService.save(circleUserRela);
    }

    @PostMapping("delete/{userId}/{circleId}")
    public Boolean deleteCircleUserRelation(@PathVariable("userId") String userId,@PathVariable("circleId") String circleId){
        QueryWrapper<CircleUserRela> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("circle_id", circleId);
        return circleService.remove(queryWrapper);
    }

    @GetMapping("/check/{userId}/isOwner/{circleId}")
    public boolean isOwner(@PathVariable("userId") String userId, @PathVariable("circleId") String circleId){
        return circleService.isOwner(userId,circleId);
    }

    @PostMapping("/setOwner/{userId}")
    public boolean setOwner(@PathVariable String userId){
        QueryWrapper<CircleUserRela> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        CircleUserRela circleUserRela = new CircleUserRela();
        circleUserRela.setIsOwner(1);
        return circleService.update(circleUserRela,queryWrapper);
    }

    @PostMapping("/unsetOwner/{userId}")
    public boolean unsetOwner(@PathVariable String userId){
        QueryWrapper<CircleUserRela> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        CircleUserRela circleUserRela = new CircleUserRela();
        circleUserRela.setIsOwner(0);
        return circleService.update(circleUserRela,queryWrapper);
    }

}
