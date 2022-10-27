package cc.vulpecula.domainbackend.controller;

import cc.vulpecula.domainbackend.classhome.CircleUserRela;
import cc.vulpecula.domainbackend.servicer.CircleService;
import cc.vulpecula.domainbackend.servicer.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/circle")
public class TestController {
    @Autowired
    private CircleService circleService;
    private UserService userService;
    @GetMapping
    String t() {
        return circleService.getById(1).toString();

    }

    @GetMapping("{id}")
    List<CircleUserRela> test(@PathVariable int id) {
        return circleService.getUsersByCircleID(id);
    }
}
