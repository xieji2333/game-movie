package com.atxieji.controller;

import com.atxieji.bean.User;
import com.atxieji.service.UserService;
import com.atxieji.service.impl.UserServiceImpl;
import com.google.code.kaptcha.Constants;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author lmhstart
 * @create 2021/10/31-23:26
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping({"/", "/login"})
    public String login(){
        return "login";
    }

//    处理登录请求
    @PostMapping("/login")
    public String loginTable(User user, HttpSession httpSession,Model model,String code){
        //获取正确的验证码
        String actualCode = (String) httpSession.getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码
        httpSession.removeAttribute(KAPTCHA_SESSION_KEY);

        //从数据库查询用户
        User login = userService.userLogin(user);
        if (login == null) {
            model.addAttribute("msg","Wrong username or password!");
            return "login";
        } else if (!actualCode.equals(code)) {
            model.addAttribute("msg","Wrong verification code");
            return "login";
        } else {
            httpSession.setAttribute("userLogin",user);
            //重定向防止表单重复提交
            return "redirect:/index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userLogin");
        return "login";
    }

    //跳转到注册页面
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    //处理注册的业务
    @PostMapping("/submit_register")
    public String submitRegister(User user, HttpSession httpSession,Model model,String code){
        String actualCode = (String) httpSession.getAttribute(KAPTCHA_SESSION_KEY);
        httpSession.removeAttribute(KAPTCHA_SESSION_KEY);
        if (actualCode.equals(code)) {
            userService.addUser(user);
            httpSession.setAttribute("userLogin",user);
            return "redirect:/index";
        } else {
            model.addAttribute("msg","Wrong verification code!");
            return "register";
        }
    }

    //判断用户名是否已存在
    @RequestMapping("/existsUser")
    @ResponseBody //返回前端以json数据
    public Map<String, Boolean> existsUser(@Param("username") String username){
//        System.out.println("ajax请求过来了");
        boolean existsUser = userService.existsUser(username);
        //将数据封装为map对象
        Map<String,Boolean> map = new HashMap<>();
        map.put("existsUser",existsUser);
        return map;
    }

    //判断确认密码与密码是否一致
    @RequestMapping("/checkPwd")
    @ResponseBody
    public Map<String,String> checkPwd(@Param("pwd") String pwd,@Param("coPwd") String coPwd){
        Map<String,String> map = new HashMap<>();
        if (pwd.equals(coPwd)) {
            map.put("equals","eq");
        } else {
            map.put("equals","notEq");
        }
        return map;
    }
}
