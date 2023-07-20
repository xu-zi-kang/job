package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
@ApiModel(value = "职位")
@Data
public class Post extends Entity {

	private Integer id;
	private String name;
	private String education;
	private String salary;
	private String description;
	private Integer companyId;
}