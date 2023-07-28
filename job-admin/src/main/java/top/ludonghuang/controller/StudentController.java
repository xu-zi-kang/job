package top.ludonghuang.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.Student;
import top.ludonghuang.framework.redis.RedisUtil;
import top.ludonghuang.framework.role.RequiresRoles;
import top.ludonghuang.framework.role.Role;
import top.ludonghuang.service.StudentService;
import top.ludonghuang.utils.Result;
import top.ludonghuang.utils.UserThreadLocal;
import top.ludonghuang.vo.UserData;

import java.util.Map;
@Api(tags = "学生账号接口")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/create")
    public Result create(@RequestBody Student student) {
        int flag = studentService.create(student);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = studentService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }


    @PostMapping("/update")
    public Result update(@RequestBody Student student) {
        int flag = studentService.update(student);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }


    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(studentService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Student student) {
        PageInfo<Student> pageInfo = studentService.query(student);
        return Result.success(pageInfo);
    }

    @PostMapping("info")
    @RequiresRoles(type = Role.STUDENT)
    public Result info(){
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        return  Result.success(studentService.detail(userData.getId()));
    }
}
