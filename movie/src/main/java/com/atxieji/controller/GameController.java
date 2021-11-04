package com.atxieji.controller;

import com.atxieji.bean.Game;
import com.atxieji.service.GameService;
import com.atxieji.service.impl.GameServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
@author lmhstart
@create 2021/11/2-21:17
*/
@Controller
public class GameController {

    @Autowired
    GameService gameService;

    //处理review页面的跳转，默认也对数据进行分页
    @RequestMapping("/review")
    public String review(Model model,Integer pageNum,String tagSelect,String yearSelect){
        //向Request域中放入当前页面是被选中的 的信息
        model.addAttribute("isActive","review");
        //将查询的结果放到请求域
        Page<Game> games = gameService.queryByTagOrYear(pageNum, 8,tagSelect,yearSelect);
        model.addAttribute("games",games);
        //将页面总数放到请求域
        int pageTotal = games.getPages();
        model.addAttribute("pageTotal",pageTotal);
        //将页码放到请求域
        model.addAttribute("num",pageNum);

        //将按钮数的集合放到请求域，让thymeleaf进行遍历
        PageInfo<Game> pageInfo = new PageInfo<>(games);
        int total = (int) pageInfo.getTotal();
        List<Integer> btnNum = getBtnNum(total, 8);
        model.addAttribute("btnNum",btnNum);

        model.addAttribute("tag",tagSelect);
        model.addAttribute("year",yearSelect);

        return "review";
    }

    //计算应该得到多少个按钮
    private List<Integer> getBtnNum(int total,int pageSize){
        int btnNum;
        int num = total % pageSize;
        if (num == 0) {
            btnNum = total / pageSize;
        } else {
            btnNum = total / pageSize + 1;
        }
        //限制最大按钮数
        if (btnNum > 5) {
            btnNum = 5;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1;i <= btnNum;i++) {
            list.add(i);
        }
        return list;
    }

}
