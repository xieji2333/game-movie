package com.atxieji.service;

import com.atxieji.bean.Game;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author lmhstart
 * @create 2021/11/2-20:38
 */
public interface GameService {
    Game queryGameByName(String name);

    Page<Game> queryByTagOrYear(Integer pageNum,Integer pageSize,String tag,String year);

    Page<Game> queryAllGame(Integer pageNum,Integer pageSize);

    int insertGame(Game game);

    int deleteGameByName(String name);

    int updateGame(Game game);
}
