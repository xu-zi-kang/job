package top.ludonghuang.controller;


import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.Predict;
import top.ludonghuang.entity.Profession;
import top.ludonghuang.entity.Resume;
import top.ludonghuang.entity.Train;
import top.ludonghuang.framework.redis.RedisUtil;
import top.ludonghuang.service.PredictService;
import top.ludonghuang.service.ResumeService;
import top.ludonghuang.service.UserDataService;
import top.ludonghuang.utils.Result;
import top.ludonghuang.utils.UserThreadLocal;
import top.ludonghuang.vo.UserData;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther: yol$
 * @Data: 2023/7/25
 */
@Api(tags = "职业预测接口")
@RestController
@RequestMapping("/predict")
public class PredictController {

    @Autowired
    private PredictService predictService;


    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserDataService userDataService;


    @PostMapping("/create")
    @ApiOperation(value = "新增预测")
    public Result createPredict(@RequestBody Predict predict){
        //获取登录用户的信息
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        //设置学生id
        predict.setStudentId(userData.getId());

        predictService.createPredict(predict);
        return Result.success();

    }


//    @GetMapping("{currentPage}/{pageSize}")
//    @ApiOperation(value = "分页查询职业预测")
//    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        Page<Predict> page = predictService.getPage(currentPage, pageSize);
//        if(currentPage > page.getPages()){
//            predictService.getPage((int) page.getPages(),pageSize);
//        }
//        return Result.success(page);
//    }



    @PostMapping("/query")
    @ApiOperation(value = "分页查询")
    public Map<String, Object> query(@RequestBody Predict predict) {

        UserData userData = userDataService.getUser();
        predict.setStudentId(userData.getId());

        PageInfo<Predict> pageInfo = predictService.query(predict);
        return Result.success(pageInfo);


    }



    @ApiOperation(value = "按id删除")
    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = predictService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }



    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody Predict predict) {
        int flag = predictService.update(predict);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }


    @ApiOperation(value = "按id查")
    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(predictService.detail(id));
    }




}
