package top.ludonghuang.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.Project;
import top.ludonghuang.entity.Resume;
import top.ludonghuang.service.ProjectService;
import top.ludonghuang.service.ResumeService;
import top.ludonghuang.service.UserDataService;
import top.ludonghuang.utils.Result;
import top.ludonghuang.vo.UserData;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Api(tags = "项目经验接口")
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserDataService userDataService;

    @PostMapping("/create")
    public Result create(@RequestBody Project project) {
        int flag = projectService.create(project);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = projectService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Project project) {
        int flag = projectService.update(project);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(projectService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Project project) {
        UserData user = userDataService.getUser();
        List<Resume> resumeParam = resumeService.detail(user.getId());
        if(resumeParam == null) {
            return Result.success(new PageInfo<>());
        }


        Set<Integer> projectSet = new HashSet<>();
        for (Resume resume : resumeParam) {
            projectSet.add(resume.getId());
        }

        // 将 trainSet 设置到 train 属性中
        project.setProjectSet(projectSet);



        PageInfo<Project> pageInfo = projectService.query(project);
        pageInfo.getList().forEach(item -> {
            List<Resume> resume = resumeService.detail2(item.getResumeId());

            for (Resume resume1 : resume) {
                item.setResume(resume1);
            }
        });
        return Result.success(pageInfo);
    }




}
