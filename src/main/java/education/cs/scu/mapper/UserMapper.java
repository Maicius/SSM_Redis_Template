package education.cs.scu.mapper;

import education.cs.scu.entity.User;

import java.util.List;

/**
 * Created by maicius on 2017/3/31.
 */
public interface UserMapper {
    User doUserLogin(User user);
}
