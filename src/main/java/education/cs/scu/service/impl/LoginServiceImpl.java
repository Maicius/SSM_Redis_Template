package education.cs.scu.service.impl;

import education.cs.scu.DAO.RedisMapper;
import education.cs.scu.entity.User;
import education.cs.scu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by maicius on 2017/3/31.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private RedisMapper redisMapper;

    public boolean doUserLogin(HttpServletRequest request, User user) throws Exception{
        User loginUser = redisMapper.doUserLoginRedis(user);
        HttpSession session = request.getSession();

        //判断密码是否一致
        if(loginUser.getPassword() != null && loginUser.getPassword().equals(user.getPassword())){
            //清除密码
            loginUser.setPassword("");
            loginUser.setNickName( "恭喜你，登陆成功, " + loginUser.getNickName());
            System.out.println("登陆成功:" + loginUser.getNickName());
            //将user保存到session
            session.setAttribute("user", loginUser);
            return true;
        }else{
            //清除密码
            loginUser.setPassword("");
            //登陆系统中，处于安全性考虑，一般不会明确告诉用户是密码错误或账户错误
            loginUser.setNickName("sorry，登陆失败");
            System.out.println("登陆失败:" + loginUser.getNickName());
            //将user保存到session
            session.setAttribute("user", loginUser);
            return false;
        }
    }

    public void doUserRegist(User user) throws Exception {
        try {
            redisMapper.doUserRegist(user);
            System.out.println("注册成功");
        }catch (Exception e){
            System.out.println("注册失败");
            e.printStackTrace();
        }
    }
}
