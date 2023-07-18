package top.ludonghuang.entity;

import lombok.Data;
import top.ludonghuang.utils.Entity;

@Data
public class Post extends Entity {

	private Integer id;
	private String name;
	private String education;
	private String salary;
	private String description;
	private Integer companyId;
}