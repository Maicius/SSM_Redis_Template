package education.cs.scu.service;

import education.cs.scu.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maicius on 2017/3/31.
 */
public interface LoginService {
    boolean doUserLogin(HttpServletRequest request, User user) throws Exception;
    void doUserRegist(User user) throws Exception;
}
