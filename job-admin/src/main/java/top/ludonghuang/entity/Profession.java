package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
@ApiModel(value = "专业")
@Data
public class Profession extends Entity {

	private Integer id;
	private String name;
	private Integer parentId;
}