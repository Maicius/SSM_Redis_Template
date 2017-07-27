package education.cs.scu.service.impl;

import education.cs.scu.mapper.RedisMapper;
import education.cs.scu.entity.User;
import education.cs.scu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by maicius on 2017/3/31.
 */
public class LoginServiceImpl implements LoginService{

    @Autowired
    private RedisMapper redisMapper;

    public boolean doUserLogin(HttpServletRequest request, User user) throws Exception{
        User loginUser = redisMapper.doUserLoginRedis(user);
        //判断密码是否一致
        if(loginUser.getPassword().equals(user.getPassword())){
            //清除密码，将user保存到session返回对象
            HttpSession session = request.getSession();
            loginUser.setPassword("");
            session.setAttribute("user", loginUser);
            return true;
        }else{
            return false;
        }
        //return userMapper.doUserLogin(user);
    }

    public void doUserRegist(User user) throws Exception {
        redisMapper.doUserRegist(user);
        //jedis.set("user".getBytes(), SerializeUtil);
    }
}
