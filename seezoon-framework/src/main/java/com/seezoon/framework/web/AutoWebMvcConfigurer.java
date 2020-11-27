package com.seezoon.framework.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.seezoon.framework.web.servlet.RequestFilter;

/**
 * @author hdf
 */
@Configuration
public class AutoWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 两个文档的支持 ，实际测试加和不加都一样，先按文档配置
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        // webjars 支持，文档也需要
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/swagger-ui/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/swagger-ui/").setViewName("forward:" + "/swagger-ui/index.html");
    }

    @Bean
    public FilterRegistrationBean<RequestFilter> traceFilter() {
        FilterRegistrationBean<RequestFilter> registration = new FilterRegistrationBean<RequestFilter>();
        registration.setFilter(new RequestFilter());
        registration.setName(RequestFilter.class.getSimpleName());
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }
}