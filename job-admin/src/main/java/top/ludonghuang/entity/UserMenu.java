package top.ludonghuang.entity;

import lombok.Data;
import top.ludonghuang.utils.Entity;

@Data
public class UserMenu extends Entity {

	private Integer userId;
	private Integer menuId;
}