package top.ludonghuang.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.UserMenu;
import top.ludonghuang.service.UserMenuService;
import top.ludonghuang.utils.Result;

import java.util.Map;
@Api(tags = "账号菜单关联表接口")
@RestController
@RequestMapping("/userMenu")
public class UserMenuController {

    @Autowired
    private UserMenuService userMenuService;

    @PostMapping("/create")
    public Result create(@RequestBody UserMenu userMenu) {
        int flag = userMenuService.create(userMenu);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = userMenuService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserMenu userMenu) {
        int flag = userMenuService.update(userMenu);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(userMenuService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody UserMenu userMenu) {
        PageInfo<UserMenu> pageInfo = userMenuService.query(userMenu);
        return Result.success(pageInfo);
    }

}
