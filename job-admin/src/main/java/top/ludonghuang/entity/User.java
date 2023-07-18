package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;

import java.util.Date;
@ApiModel(value = "管理员账号")
@Data
public class User extends Entity {

    private Integer id;
    private String userName;
    private String name;
    private String password;
    private Date loginTime;
}
