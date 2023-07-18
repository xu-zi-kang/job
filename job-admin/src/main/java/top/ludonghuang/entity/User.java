package top.ludonghuang.entity;

import lombok.Data;
import top.ludonghuang.utils.Entity;

import java.util.Date;

@Data
public class User extends Entity {

    private Integer id;
    private String userName;
    private String name;
    private String password;
    private Date loginTime;
}
