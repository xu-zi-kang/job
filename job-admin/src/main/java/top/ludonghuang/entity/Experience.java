package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
import java.util.Date;

@ApiModel(value = "实习经历")
@Data
public class Experience extends Entity {

	private Integer id;
	private String company;
	private String post;
	private String salary;
	private String description;
	private Date joinDate;
	private Date leaveDate;
	private Integer resumeId;

	private Resume resume;
}