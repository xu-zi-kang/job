package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
import java.util.Date;
@ApiModel(value = "学生账号")
@Data
public class Student extends Entity {

	private Integer id;
	private String name;
	private String account;
	private String password;
	private Date birthday;
	private Integer professionId;
	private String college;
	private String education;
	private String phone;
	private String sex;
	private String photo;
	private Date graduateDate;
}