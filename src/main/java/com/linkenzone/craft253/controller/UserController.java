package com.linkenzone.craft253.controller;

import com.linkenzone.craft253.entities.User;
import com.linkenzone.craft253.service.IUserService;
import com.linkenzone.craft253.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private IUserService userService= new UserServiceImpl();

    @PostMapping(value = "/user/login")
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session) {
        if(userService.checkLogin(new User(username,password))){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("username",username);
            return "redirect:/index.html";
        }else {
            //登陆失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }

    @GetMapping(value = "logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();//销毁用户的session
        return "index";
    }

}
