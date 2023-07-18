package top.ludonghuang.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.ludonghuang.utils.Entity;
import java.util.Date;

@Data
@ApiModel(value = "证书")
public class Certificate extends Entity {

	private Integer id;
	private String name;
	private String file;
	private Date obtainDate;
	private Integer resumeId;

	private Resume resume;
}