package com.atxieji.bean;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @author lmhstart
 * @create 2021/11/1-13:59
 */
@Data
@Repository
public class User {
    private Integer id;
    private String username;
    private String password;
}
