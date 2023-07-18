package top.ludonghuang.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.Article;
import top.ludonghuang.framework.redis.RedisUtil;
import top.ludonghuang.service.ArticleService;
import top.ludonghuang.utils.Result;
import top.ludonghuang.utils.UserThreadLocal;
import top.ludonghuang.vo.UserData;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/create")
    public Result create(@RequestBody Article article) {
        //获取登录用户的信息
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        //设置一些属性
        article.setCreateDate(new Date());
        article.setUpdateDate(new Date());
        article.setCreateUser(userData.getId());
        int flag = articleService.create(article);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = articleService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Article article) {
        //获取登录用户的信息
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        //设置一些属性
        article.setUpdateDate(new Date());
        article.setCreateUser(userData.getId());
        int flag = articleService.update(article);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(articleService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Article article) {
        PageInfo<Article> pageInfo = articleService.query(article);
        return Result.success(pageInfo);
    }

}
