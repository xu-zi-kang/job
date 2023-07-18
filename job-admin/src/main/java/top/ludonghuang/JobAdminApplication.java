package top.ludonghuang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.ludonghuang.mapper")
public class JobAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobAdminApplication.class, args);
    }
}
