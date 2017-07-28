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
        //HashOperations hashOperations = redisTemplate.opsForHash();
        return (User)redisTemplate.opsForHash().get(USER_KEY, user.getUserName());

    }

    public void doUserRegist(User user) throws Exception {
//        Jedis jedis = RedisPool.getJedis();
//        //Json = mapper.writeValueAsString(user);
//        System.out.println("username:" + user.getUserName());
//        jedis.hset(user.getUserName(), "userName", user.getUserName());
//        int i = jedis.hset(user.getUserName(), "password", user.getPassword()).intValue();
//        RedisPool.returnResource(jedis);
//        return i;
        this.redisTemplate.opsForHash().put(USER_KEY, user.getUserName(), user);

    }

}
