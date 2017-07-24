package education.cs.scu.service;

import education.cs.scu.entity.User;

/**
 * Created by maicius on 2017/3/31.
 */
public interface LoginService {
    User doUserLogin(User user) throws Exception;
    int doUserRegist(User user) throws Exception;
}
