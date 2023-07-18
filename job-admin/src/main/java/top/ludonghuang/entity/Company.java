package top.ludonghuang.entity;

import lombok.Data;
import top.ludonghuang.utils.Entity;

@Data
public class Company extends Entity {

	private Integer id;
	private String name;
	private String account;
	private String password;
	private String contact;
	private String telephone;
	private String email;
	private String addr;
	private String url;
	private String size;
	private String type;
	private String logo;
	private String description;
}