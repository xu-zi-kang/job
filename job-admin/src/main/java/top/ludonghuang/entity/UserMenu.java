package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
@ApiModel(value = "账号_菜单")
@Data
public class UserMenu extends Entity {

	private Integer userId;
	private Integer menuId;
}