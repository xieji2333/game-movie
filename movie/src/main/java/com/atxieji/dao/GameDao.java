package com.atxieji.dao;

import com.atxieji.bean.Game;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lmhstart
 * @create 2021/11/2-20:29
 */
@Mapper
public interface GameDao {
    Game queryGameByName(String name);

    Page<Game> queryByTagOrYear(@Param("tag") String tag, @Param("year") String year);

    Page<Game> queryAllGame();

    int insertGame(Game game);

    int deleteGameByName(String name);

    int updateGame(Game game);
}
