package education.cs.scu.controller;

import education.cs.scu.entity.User;
import education.cs.scu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by maicius on 2017/3/31.
 */
@Controller
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
        System.out.println("login_result:" + loginUser.toString());
        mv.setViewName("login");
        System.out.println("Controller finished");
        return mv;
    }

}
