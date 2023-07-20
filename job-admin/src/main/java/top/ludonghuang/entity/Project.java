package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@ApiModel(value = "项目经验")
@Data
public class Project extends Entity {

	private Integer id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Integer resumeId;

	private Resume resume;

	private Set<Integer> projectSet = new HashSet<Integer>();

}