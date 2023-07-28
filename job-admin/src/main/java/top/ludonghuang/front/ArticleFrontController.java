package top.ludonghuang.front;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ludonghuang.entity.Article;
import top.ludonghuang.service.ArticleService;
import top.ludonghuang.utils.Result;

import java.util.Map;

@RestController
@RequestMapping("/f/article")
public class ArticleFrontController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private RedisTemplate redisTemplate;



/**
 * @Description: 文章详情,按id查
 * @Param: [id]
 * @Return: top.ludonghuang.utils.Result
 * @Author: yol
 * @Date: 2023/7/27 9:25
 */
    @PostMapping("/detail")
    public Result detail(Integer id) {
        //每点击一次浏览量加一（每调用一次方法，浏览量加一）
        Double views = redisTemplate.opsForZSet().incrementScore("views", id, 1);
        Article article = articleService.detail(id);
        if(views != null) {
            article.setViews(views.intValue());
        } else {
            article.setViews(0);
        }
        return Result.success(article);
    }





    /**
     * @Description: 文章详情,按title查
     * @Param: [id]
     * @Return: top.ludonghuang.utils.Result
     * @Author: yol
     * @Date: 2023/7/27 9:25
     */
    @PostMapping("/detail2")
    public Result detail2(String title) {
        //每点击一次浏览量加一（每调用一次方法，浏览量加一）
        Double views = redisTemplate.opsForZSet().incrementScore("views", title, 1);
        Article article = articleService.detail2(title);
        if(views != null) {
            article.setViews(views.intValue());
        } else {
            article.setViews(0);
        }
        return Result.success(article);
    }






    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Article article) {
        PageInfo<Article> pageInfo = articleService.getArticlesByChannelId(article);
        return Result.success(pageInfo);
    }


}
