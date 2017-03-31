package education.cs.scu.service;

import education.cs.scu.entity.User;

import java.util.List;

/**
 * Created by maicius on 2017/3/31.
 */
public interface LoginService {
    public User doUserLogin(User user) throws Exception;
}
