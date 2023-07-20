package top.ludonghuang.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.Certificate;
import top.ludonghuang.entity.Resume;
import top.ludonghuang.service.CertificateService;
import top.ludonghuang.service.ResumeService;
import top.ludonghuang.service.UserDataService;
import top.ludonghuang.utils.Result;
import top.ludonghuang.vo.UserData;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/certificate")
@Api(tags = "证书接口")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserDataService userDataService;

    @PostMapping("/create")
    public Result create(@RequestBody Certificate certificate) {
        int flag = certificateService.create(certificate);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = certificateService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Certificate certificate) {
        int flag = certificateService.update(certificate);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(certificateService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Certificate certificate) {
        UserData user = userDataService.getUser();
        List<Resume> resumeParam =  resumeService.detail(user.getId());
        if(resumeParam == null) {
            return Result.success(new PageInfo<>());
        }



        Set<Integer> certificateSet = new HashSet<>();
        for (Resume resume : resumeParam) {
            certificateSet.add(resume.getId());
        }

        // 将 trainSet 设置到 train 属性中
        certificate.setCertificateSet(certificateSet);




        PageInfo<Certificate> pageInfo = certificateService.query(certificate);
        pageInfo.getList().forEach(item -> {

            List<Resume> resume = resumeService.detail2(item.getResumeId());
            for (Resume resume1 : resume) {
                item.setResume(resume1);
            }

        });
        return Result.success(pageInfo);
    }

}
