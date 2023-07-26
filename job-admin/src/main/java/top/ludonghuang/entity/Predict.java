package top.ludonghuang.entity;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.ludonghuang.utils.Entity;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: yol$
 * @Data: 2023/7/25
 */



@ApiModel(value = "职业预测")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Predict extends Entity {

    private Integer id;
    private String sex;
    private String profession;
    private String job;
    private String city;
    private String company;
    private String salary;
    private String score;
    private Integer studentId;



}
