package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
@ApiModel(value = "菜单")
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