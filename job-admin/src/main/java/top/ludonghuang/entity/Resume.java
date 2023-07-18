package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
@ApiModel(value = "简历")
@Data
public class Resume extends Entity {

	private Integer id;
	private String name;
	private String jobStatus;
	private String evaluate;
	private String skill;
	private Integer studentId;
	private Integer status; // 0关闭|1开放
}