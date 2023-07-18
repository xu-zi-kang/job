package top.ludonghuang.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.Resume;
import top.ludonghuang.entity.Train;
import top.ludonghuang.framework.redis.RedisUtil;
import top.ludonghuang.service.ResumeService;
import top.ludonghuang.service.TrainService;
import top.ludonghuang.service.UserDataService;
import top.ludonghuang.utils.Result;
import top.ludonghuang.utils.UserThreadLocal;
import top.ludonghuang.vo.UserData;

import java.util.Map;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserDataService userDataService;


    @PostMapping("/create")
    public Result create(@RequestBody Train train) {

        int flag = trainService.create(train);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }


    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = trainService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Train train) {
        int flag = trainService.update(train);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(trainService.detail(id));
    }



    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Train train) {
        UserData user = userDataService.getUser();

        Resume resumeParam = resumeService.detail(user.getId());
        if(resumeParam == null) {
            return Result.success(new PageInfo<>());
        }

        train.setResumeId(resumeParam.getId());
        PageInfo<Train> pageInfo = trainService.query(train);
        pageInfo.getList().forEach(item -> {
            Resume resume = resumeService.detail(item.getResumeId());
            item.setResume(resume);
        });
        return Result.success(pageInfo);
    }








}
