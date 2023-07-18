package top.ludonghuang.entity;

import lombok.Data;
import top.ludonghuang.utils.Entity;

@Data
public class Profession extends Entity {

	private Integer id;
	private String name;
	private Integer parentId;
}