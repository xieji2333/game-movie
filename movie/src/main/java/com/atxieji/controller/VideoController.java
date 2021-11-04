package com.atxieji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lmhstart
 * @create 2021/11/1-23:12
 */
@Controller
public class VideoController {

    @GetMapping("/assassin")
    public String assassin(){
        return "assassin";
    }

}
