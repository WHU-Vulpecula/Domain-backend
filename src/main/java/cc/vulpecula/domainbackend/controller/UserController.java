package cc.vulpecula.domainbackend.controller;

import cc.vulpecula.domainbackend.classhome.User;
import cc.vulpecula.domainbackend.servicer.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    boolean test(@RequestBody User user) {
        return userService.save(user);
    }
    @GetMapping("/login")
    boolean login(@RequestParam Integer id,@RequestParam String password){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("id",id).eq("password",password);
        User temp=userService.getOne(wrapper);
        if(temp!=null)return true;
        else return false;
    }

}