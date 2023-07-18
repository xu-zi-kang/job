package top.ludonghuang.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ludonghuang.entity.Post;
import top.ludonghuang.framework.redis.RedisUtil;
import top.ludonghuang.service.PostService;
import top.ludonghuang.service.UserDataService;
import top.ludonghuang.utils.Result;
import top.ludonghuang.utils.UserThreadLocal;
import top.ludonghuang.vo.UserData;

import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserDataService userDataService;

    @PostMapping("/create")
    public Result create(@RequestBody Post post) {
        //获取登录用户的信息
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        //设置企业id
        post.setCompanyId(userData.getId());
        int flag = postService.create(post);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = postService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Post post) {
        int flag = postService.update(post);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(postService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Post post) {
        UserData userData = userDataService.getUser();
        post.setCompanyId(userData.getId());
        PageInfo<Post> pageInfo = postService.query(post);
        return Result.success(pageInfo);
    }

}
