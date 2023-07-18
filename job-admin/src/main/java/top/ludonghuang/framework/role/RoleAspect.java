package top.ludonghuang.framework.role;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.ludonghuang.framework.exception.NoAuthException;
import top.ludonghuang.framework.redis.RedisUtil;
import top.ludonghuang.utils.Status;
import top.ludonghuang.utils.UserThreadLocal;
import top.ludonghuang.vo.UserData;

import java.lang.reflect.Method;

@Component
@Aspect
public class RoleAspect {

    @Autowired
    private RedisUtil redisUtil;

    @Pointcut
    public void pointCut() {

    }

    @Before("execution(* top.ludonghuang.controller.*Controller.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //通过方法获取注解
        RequiresRoles annotation = method.getAnnotation(RequiresRoles.class);
        if(annotation != null) {
            //获取本地线程中的token
            String token = UserThreadLocal.get();
            //根据token获取redis中的数据
            UserData userData = (UserData) redisUtil.get(token);
            if (userData != null) {
                //判断redis中存储的type值和方法上设置的type值是否相等
                if (!userData.getType().equals(annotation.type().getCode())) {
                    throw new NoAuthException(Status.NO_AUTH.getMsg());
                }

            } else {
                throw new NoAuthException(Status.NO_AUTH.getMsg());
            }
        }
    }
}
