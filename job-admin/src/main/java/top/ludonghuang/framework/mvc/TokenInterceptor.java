package top.ludonghuang.framework.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.ludonghuang.framework.exception.TokenException;
import top.ludonghuang.framework.redis.RedisUtil;
import top.ludonghuang.utils.Status;
import top.ludonghuang.utils.UserThreadLocal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        boolean flag = redisUtil.hasKey(token);
        if (flag) {
            UserThreadLocal.set(token);
            redisUtil.expire(token, RedisUtil.EXPR);
        } else {
            throw new TokenException(Status.TOKEN_ERROR.getMsg());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清除ThreadLocal
        UserThreadLocal.remove();
    }
}
