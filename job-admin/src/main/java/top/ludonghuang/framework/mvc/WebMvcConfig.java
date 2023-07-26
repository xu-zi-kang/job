package top.ludonghuang.framework.mvc;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import top.ludonghuang.framework.exception.TokenException;
import top.ludonghuang.framework.redis.RedisUtil;
import top.ludonghuang.utils.Status;
import top.ludonghuang.utils.UploadConfig;
import top.ludonghuang.utils.UserThreadLocal;
import top.ludonghuang.vo.UserData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.github.xiaoymin.knife4j.core.util.CollectionUtils.newArrayList;
import static java.util.Collections.singletonList;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;



@Configuration
@EnableSwagger2
@EnableKnife4j
public class WebMvcConfig  implements WebMvcConfigurer {

    @Autowired
    private UploadConfig uploadConfig;


    @Autowired
    private RedisUtil redisUtil;

    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/job/**").addPathPatterns("/**")
      .excludePathPatterns("/login/**", "/upload/**", "/f/**","/doc.html","/swagger-resources","/webjars/**","/v2/**");
      //.excludePathPatterns("/login/**", "/upload/**", "/f/**","/doc.html","/swagger-resources","/webjars/**","/v2/**","/resume/**","/train/**","/predict/**")
      //.excludePathPatterns("/resume/**","/train/**","/predict/**");
    }



    //使用CorsFilter解决跨域问题
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许跨域请求的域名
        corsConfiguration.addAllowedOrigin("*");
        //允许跨域请求的方法
        corsConfiguration.addAllowedMethod("*");
        //允许任何头部
        corsConfiguration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        CorsFilter corsFilter = new CorsFilter(corsConfigurationSource);
        return corsFilter;
    }

    //添加资源映射处理器
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(uploadConfig.getAccessPath())
                .addResourceLocations("file:"+uploadConfig.getUploadFolder());

        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");

    }


    @Bean
    public Docket createRestApi() {
        // 文档类型
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.ludonghuang.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Arrays.asList(securityContext()))
                // ApiKey的name需与SecurityReference的reference保持一致
                .securitySchemes(Arrays.asList(new ApiKey("token", "token", SecurityScheme.In.HEADER.name())));

    }


    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                //.forPaths(PathSelectors.regex("/*.*"))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(
                new SecurityReference("token", authorizationScopes));
    }




    public UserData getUser() {
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        if(userData != null) {
            return userData;
        } else {
            throw new TokenException(Status.TOKEN_ERROR.getMsg());
        }
    }






    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("职业预判系统接口文档")
                .version("1.0")
                .description("职业预判系统接口文档")
                .build();
    }






}
