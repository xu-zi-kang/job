package top.ludonghuang.entity;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
import java.util.Date;
@ApiModel(value = "职位收藏")
@Data
public class Favor extends Entity {

	private Integer id;
	private Integer companyId;
	private Integer postId;
	private Integer studentId;
	private Date favorDate;

	private Post post;
	private Company company;
	private Student student;
}