package education.cs.scu.redis;

import education.cs.scu.DAO.impl.RedisMapperImpl;
import education.cs.scu.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by maicius on 2017/7/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext-dao.xml",
        "classpath*: /applicationContext-redis.xml",
        "classpath*: /applicationContext-service.xml",
        "classpath*: /applicationContext-transaction.xml",
        "classpath*: /springMVC.xml"})
public class SpringTestBased {
    @Autowired
    private RedisMapperImpl redisMapper;

    @Test
    public void testRedis(){
        User user = new User("189test", "110110", "maicius");
        try {
            redisMapper.doUserRegist(user);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("testRedis: Regist Failed");
        }
        User loginUser = new User("189test", "110110");
        User testUser = new User();
        try {
            testUser = redisMapper.doUserLoginRedis(loginUser);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("testRedis: Login Failed");
        }
        Assert.assertEquals("189test", testUser.getUserName());
    }
}
