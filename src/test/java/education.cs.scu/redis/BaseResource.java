package education.cs.scu.redis;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext-dao.xml",
        "classpath*: /applicationContext-redis.xml",
        "classpath*: /applicationContext-service.xml",
        "classpath*: /applicationContext-transaction.xml",
        "classpath*: /springMVC.xml"})
public interface BaseResource {

}
