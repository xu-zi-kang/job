package top.ludonghuang.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.Dict;
import top.ludonghuang.service.DictService;
import top.ludonghuang.utils.Result;

import java.util.Map;

@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    @PostMapping("/create")
    public Result create(@RequestBody Dict dict) {
        int flag = dictService.create(dict);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = dictService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Dict dict) {
        int flag = dictService.update(dict);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(dictService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Dict dict) {
        PageInfo<Dict> pageInfo = dictService.query(dict);
        return Result.success(pageInfo);
    }

}
