package top.ludonghuang.entity;

import lombok.Data;
import top.ludonghuang.utils.Entity;
import java.util.Date;

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