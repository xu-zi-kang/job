package top.ludonghuang.entity;

import lombok.Data;
import top.ludonghuang.utils.Entity;

@Data
public class Dict extends Entity {

	private Integer id;
	private String dictKey;
	private String dictVal;
	private Integer sort;
	private Integer status; // 0正常|1删除
	private Integer typeId;
}