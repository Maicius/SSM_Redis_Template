package education.cs.scu.DAO.impl;

import education.cs.scu.DAO.RedisMapper;
import education.cs.scu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
/**
 * Created by maicius on 2017/7/27.
 */
@Repository
public class RedisMapperImpl implements RedisMapper{

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    private static String USER_KEY = "ADMIN_USER";
    public User doUserLoginRedis(User user) throws Exception {
        User loginUser =  (User)redisTemplate.opsForHash().get(USER_KEY, user.getUserName());
        if(loginUser !=null){
            return loginUser;
        }else{
            return new User();
        }

    }

    public void doUserRegist(User user) throws Exception {
        this.redisTemplate.opsForHash().put(USER_KEY, user.getUserName(), user);
    }

}
