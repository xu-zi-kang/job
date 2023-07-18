package top.ludonghuang.entity;

import lombok.Data;
import top.ludonghuang.utils.Entity;
import java.util.Date;

@Data
public class Channel extends Entity {

	private Integer id;
	private String name;
	private Integer parentId;
	private String channelImg;
	private String summary;
	private String single; // Y单页|其他非单页
	private String url;
	private String content;
	private Integer sort;
	private Date createDate;
	private Integer createUser;
	private String deletedFlag;
	private Integer postion;
}