package education.cs.scu.mapper;

import education.cs.scu.entity.User;

/**
 * 使用mysql进行用户登陆的方法
 * Created by maicius on 2017/3/31.
 */
public interface UserMapper {
    User doUserLogin(User user) throws Exception;
}
