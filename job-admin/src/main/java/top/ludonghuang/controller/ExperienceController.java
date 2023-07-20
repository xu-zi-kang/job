package top.ludonghuang.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.Experience;
import top.ludonghuang.entity.Resume;
import top.ludonghuang.service.ExperienceService;
import top.ludonghuang.service.ResumeService;
import top.ludonghuang.service.UserDataService;
import top.ludonghuang.utils.Result;
import top.ludonghuang.vo.UserData;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Api(tags = "实习经历接口")
@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserDataService userDataService;

    @PostMapping("/create")
    public Result create(@RequestBody Experience experience) {
        int flag = experienceService.create(experience);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = experienceService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Experience experience) {
        int flag = experienceService.update(experience);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(experienceService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Experience experience) {
        UserData user = userDataService.getUser();
        List<Resume> resumeParam = resumeService.detail(user.getId());
        if(resumeParam == null) {
            return Result.success(new PageInfo<>());
        }


        for (Resume resume : resumeParam) {
            experience.setResumeId(resume.getId());
        }


        Set<Integer> experienceSet = new HashSet<>();
        for (Resume resume : resumeParam) {
            experienceSet.add(resume.getId());
        }
        // 将 trainSet 设置到 train 属性中
        experience.setExperienceSet(experienceSet);




        PageInfo<Experience> pageInfo = experienceService.query(experience);
        pageInfo.getList().forEach(item -> {

            List<Resume> resume = resumeService.detail2(item.getResumeId());
            for (Resume resume1 : resume) {
                item.setResume(resume1);
            }



        });
        return Result.success(pageInfo);
    }

}
