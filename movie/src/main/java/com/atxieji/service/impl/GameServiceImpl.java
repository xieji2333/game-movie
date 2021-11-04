package com.atxieji.service.impl;

import com.atxieji.bean.Game;
import com.atxieji.dao.GameDao;
import com.atxieji.service.GameService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lmhstart
 * @create 2021/11/2-20:39
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;


    @Override
    public Game queryGameByName(String name) {
        return null;
    }

    @Override
    public Page<Game> queryByTagOrYear(Integer pageNum,Integer pageSize,String tag, String year) {
        PageHelper.startPage(pageNum,pageSize);
        return gameDao.queryByTagOrYear(tag,year);
    }

    @Override
    public Page<Game> queryAllGame(Integer pageNum,Integer pageSize) {
        //使用PageHelper来分页，只需要在dao前使用就可以了，非常好用！
        PageHelper.startPage(pageNum, pageSize);

        return gameDao.queryAllGame();
    }

    @Override
    public int insertGame(Game game) {
        return 0;
    }

    @Override
    public int deleteGameByName(String name) {
        return 0;
    }

    @Override
    public int updateGame(Game game) {
        return 0;
    }
}
