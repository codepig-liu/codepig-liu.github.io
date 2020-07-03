package com.slxy.config;

import com.slxy.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurerAdapter过时, WebMvcConfigurationSupport 失效
 * 因为在springboot中默认是加载了mvc的配置，
 * 可以查看注释@WebMvcAutoConfiguration,这个注释有一个条件注释@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)。
 * 也就是说只要在容器中发现有WebMvcConfigurationSupport这个类，那就会失效，
 * 我们就必须在我们的主类上添加@@EnableWebMvc注解，这样我就无法访问默认的静态资源了。
 * 因为WebMvcConfigurerAdapter过时，是因为java8中接口有默认实现，而WebMvcConfigurerAdapter实现的就是WebMvcConfigurer方法，
 * 所以我只要实现WebMvcConfigurer接口，然后重写我们需要的方法即可
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //    @Bean
//    public  WebMvcConfigurationSupport webMvcConfigurationSupport(){
//        WebMvcConfigurationSupport support = new WebMvcConfigurationSupport(){
//            @Override
//            protected void addViewControllers(ViewControllerRegistry registry) {
////                super.addViewControllers(registry);
//                //重置默认访问页
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//            }
//        };
//        return  support;
//
//    }
//将组件注册到容器中
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //重置默认访问页
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            //   其中addPathPatterns("/**")对所有请求都拦截，但是(excludePathPatterns)排除了一些连接请求的拦截。
            //   spring 1.x之前的话，添加拦截器是不需要考虑静态资源目录，因为拦截器是不会拦截的。
            //   而spring 2.x后呢，你会发现静态资源访问不到的。所以需要在excludePathPatterns上排除uri连接。
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/webjars/**", "/asserts/**", "/index.html", "/", "/user/login");
            }
        };
        return configurer;
    }
}
