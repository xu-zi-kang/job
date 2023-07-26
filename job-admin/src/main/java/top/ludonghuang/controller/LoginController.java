package top.ludonghuang.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.ludonghuang.entity.Company;
import top.ludonghuang.entity.Student;
import top.ludonghuang.entity.User;
import top.ludonghuang.framework.redis.RedisUtil;
import top.ludonghuang.framework.role.Role;
import top.ludonghuang.service.CompanyService;
import top.ludonghuang.service.StudentService;
import top.ludonghuang.service.UserService;
import top.ludonghuang.utils.Result;
import top.ludonghuang.vo.UserData;

import java.util.Map;
import java.util.UUID;
@Api(tags = "登录接口")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> map) {
        String account = map.get("account");
        String password = map.get("password");
        String type = map.get("type");

        boolean flag = false;
        UserData userData = new UserData();

        if(Role.ADMIN.getCode().equals(Integer.parseInt(type))) {
            //管理员登录
            User user = userService.login(account, password);
            if(user != null) {
                flag = true;
                userData.setId(user.getId());
                userData.setAccount(user.getUserName());
                userData.setName(user.getName());
                userData.setType(Role.ADMIN.getCode());
            }
        }
        if(Role.COMPANY.getCode().equals(Integer.parseInt(type))) {
            //企业登录
            Company company = companyService.login(account, password);
            if(company != null) {
                flag = true;
                userData.setId(company.getId());
                userData.setAccount(company.getAccount());
                userData.setName(company.getName());
                userData.setType(Role.COMPANY.getCode());
            }
        }
        if(Role.STUDENT.getCode().equals(Integer.parseInt(type))) {
            //学生登录
            Student student = studentService.login(account, password);
            if(student != null) {
                flag = true;
                userData.setId(student.getId());
                userData.setAccount(student.getAccount());
                userData.setName(student.getName());
                userData.setType(Role.STUDENT.getCode());
            }
        }

        if(flag) {
            //登录成功
            //1、生成token
            String token = UUID.randomUUID().toString();
            //2、存入redis
            userData.setToken(token);
            redisUtil.set(token, userData, RedisUtil.EXPR);
            //3、响应数据
            return Result.success(userData);
        } else {
            return Result.error("用户名或密码错误");
        }
    }





}
