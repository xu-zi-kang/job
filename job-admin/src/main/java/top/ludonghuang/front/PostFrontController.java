package top.ludonghuang.front;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ludonghuang.service.PostService;
import top.ludonghuang.utils.Result;

import java.util.Map;

@RestController
@RequestMapping("/f/post")
public class PostFrontController {

    @Autowired
    private PostService postService;

    @PostMapping("/query")
    public Map<String,Object> getPostList(@RequestBody Map<String,Object> map) {
        PageInfo<Map<String, Object>> postList = postService.getPostList(map);
        return Result.success(postList);
    }
}
