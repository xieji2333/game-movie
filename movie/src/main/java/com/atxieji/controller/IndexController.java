package com.atxieji.controller;

import com.atxieji.bean.Game;
import com.atxieji.service.GameService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author lmhstart
 * @create 2021/11/1-18:37
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("isActive","index");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model){
        //向Request域中放入当前页面是被选中的 的信息
        model.addAttribute("isActive","about");
        return "about";
    }

    @GetMapping("/joinus")
    public String joinus(Model model){
        model.addAttribute("isActive","joinus");
        return "joinus";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("isActive","contact");
        return "contact";
    }

    //利用springmvc的精确匹配机制，当找不到请求路径时，就会匹配下面的 /* 从而实现404页面的跳转
    @RequestMapping("/*")
    public String errorNotFound(){
        return "404";
    }
}
