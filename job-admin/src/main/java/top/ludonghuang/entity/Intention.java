package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;

import java.util.HashSet;
import java.util.Set;

@ApiModel(value = "求职意向")
@Data
public class Intention extends Entity {

	private Integer id;
	private String name;
	private String salary;
	private String city;
	private String type;
	private String industry;
	private Integer resumeId;

	private Resume resume;
	private Set<Integer> intentionSet = new HashSet<Integer>();
}