package top.ludonghuang.entity;

import lombok.Data;
import top.ludonghuang.utils.Entity;
import java.util.Date;

@Data
public class Train extends Entity {

	private Integer id;
	private Date startDate;
	private Date endDate;
	private String company;
	private String course;
	private Integer resumeId;

	private Resume resume;
}