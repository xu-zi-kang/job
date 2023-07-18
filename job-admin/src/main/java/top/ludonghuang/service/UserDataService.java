package top.ludonghuang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ludonghuang.framework.exception.TokenException;
import top.ludonghuang.framework.redis.RedisUtil;
import top.ludonghuang.utils.Status;
import top.ludonghuang.utils.UserThreadLocal;
import top.ludonghuang.vo.UserData;

@Service
public class UserDataService {

    @Autowired
    private RedisUtil redisUtil;

    public UserData getUser() {
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        if(userData != null) {
            return userData;
        } else {
            throw new TokenException(Status.TOKEN_ERROR.getMsg());
        }
    }
}
