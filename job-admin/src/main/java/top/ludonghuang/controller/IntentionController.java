package top.ludonghuang.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.Intention;
import top.ludonghuang.entity.Resume;
import top.ludonghuang.service.IntentionService;
import top.ludonghuang.service.ResumeService;
import top.ludonghuang.service.UserDataService;
import top.ludonghuang.utils.Result;
import top.ludonghuang.vo.UserData;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Api(tags = "求职意向接口")
@RestController
@RequestMapping("/intention")
public class IntentionController {

    @Autowired
    private IntentionService intentionService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserDataService userDataService;

    @PostMapping("/create")
    public Result create(@RequestBody Intention intention) {
        int flag = intentionService.create(intention);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = intentionService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Intention intention) {
        int flag = intentionService.update(intention);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(intentionService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Intention intention) {
        UserData user = userDataService.getUser();
        List<Resume> resumeParam = resumeService.detail(user.getId());
        if(resumeParam == null) {
            return Result.success(new PageInfo<>());
        }



        Set<Integer> intentionSet = new HashSet<>();
        for (Resume resume : resumeParam) {
            intentionSet.add(resume.getId());
        }

        // 将 trainSet 设置到 train 属性中
        intention.setIntentionSet(intentionSet);

        for (Resume resume : resumeParam) {
            intention.setResumeId(resume.getId());
        }



        PageInfo<Intention> pageInfo = intentionService.query(intention);
        pageInfo.getList().forEach(item -> {

            List<Resume> resume = resumeService.detail2(item.getResumeId());
            for (Resume resume1 : resume) {
                item.setResume(resume1);
            }

        });
        return Result.success(pageInfo);
    }

}
