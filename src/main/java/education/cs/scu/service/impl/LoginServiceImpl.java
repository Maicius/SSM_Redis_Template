package education.cs.scu.service.impl;

import education.cs.scu.entity.User;
import education.cs.scu.mapper.UserMapper;
import education.cs.scu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by maicius on 2017/3/31.
 */
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserMapper userMapper;

    public User doUserLogin(User user) throws Exception{
        return userMapper.doUserLogin(user);
    }
}
