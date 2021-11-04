package com.atxieji.bean;

import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lmhstart
 * @create 2021/11/2-20:19
 */
@Repository
@Data
public class Game {
    private Integer id;
    private String name;
    private String tag;
    private String year;
    private String info;
    private String src;
}
