package cc.vulpecula.domainbackend.servicer.impl;

import cc.vulpecula.domainbackend.classhome.User;
import cc.vulpecula.domainbackend.mapper.UserMapper;
import cc.vulpecula.domainbackend.servicer.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
}
