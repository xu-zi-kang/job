package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
@ApiModel(value = "字典管理")
@Data
public class Dict extends Entity {

	private Integer id;
	private String dictKey;
	private String dictVal;
	private Integer sort;
	private Integer status; // 0正常|1删除
	private Integer typeId;
}