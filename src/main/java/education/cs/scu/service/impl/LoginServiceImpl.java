package education.cs.scu.service.impl;

import education.cs.scu.redis.RedisPool;
import education.cs.scu.entity.User;
import education.cs.scu.mapper.UserMapper;
import education.cs.scu.service.LoginService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;


/**
 * Created by maicius on 2017/3/31.
 */
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserMapper userMapper;
    ObjectMapper mapper = new ObjectMapper();
    private String Json;
    public User doUserLogin(User user) throws Exception{
        return userMapper.doUserLogin(user);
    }

    public int doUserRegist(User user) throws Exception {
        Jedis jedis = RedisPool.getJedis();
        //Json = mapper.writeValueAsString(user);
        System.out.println("username:" + user.getUserName());
        jedis.hset(user.getUserName(), "userName", user.getUserName());
        int i = jedis.hset(user.getUserName(), "password", user.getPassword()).intValue();
        RedisPool.returnResource(jedis);
        return i;
        //jedis.set("user".getBytes(), SerializeUtil);
    }
}
