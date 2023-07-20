package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@ApiModel(value = "培训经历")
@Data
public class Train extends Entity {

	private Integer id;
	private Date startDate;
	private Date endDate;
	private String company;
	private String course;
	private Integer resumeId;

	private Resume resume;


	private Set<Integer> trainSet = new HashSet<Integer>();


}