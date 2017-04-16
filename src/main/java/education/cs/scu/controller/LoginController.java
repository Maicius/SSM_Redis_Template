package education.cs.scu.controller;

import education.cs.scu.entity.User;
import education.cs.scu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by maicius on 2017/3/31.
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value="/userLogin")
    public ModelAndView Test(HttpServletRequest request,
                             @RequestParam(value="userName") String userName,
                             @RequestParam(value="password") String password) throws Exception{
        User user = new User(userName, password);
        System.out.println(userName);
        ModelAndView mv = new ModelAndView();
        User loginUser = loginService.doUserLogin(user);
        HttpSession session = request.getSession();
        if(loginUser != null) {
            session.setAttribute("user", loginUser);
        }else{
            User wrongUser = new User();
            wrongUser.setNickName("该用户不存在");
            session.setAttribute("user", wrongUser);
        }
        mv.setViewName("login");
        System.out.println("Controller finished");
        return mv;
    }

}
