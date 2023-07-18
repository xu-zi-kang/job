package top.ludonghuang.entity;

import lombok.Data;
import top.ludonghuang.utils.Entity;

@Data
public class Menu extends Entity {

	private Integer id;
	private String name;
	private String icon;
	private String href;
	private String perms;
	private Integer parentId;
	private Integer type; // 0管理员|1企业|2学生
}