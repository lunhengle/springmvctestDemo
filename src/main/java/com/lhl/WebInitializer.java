package com.lhl;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by lenovo on 2016/3/19.
 * 注解方式配置加载web.xml
 */
public class WebInitializer implements WebApplicationInitializer {

    /**
     * web 启动时调用.
     *
     * @param servletContext
     * @throws ServletException
     */
    public void onStartup(ServletContext servletContext) throws ServletException {
        //配置spring监听
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
        //配置springmvc 上下文
        AnnotationConfigWebApplicationContext springMvcContext = new AnnotationConfigWebApplicationContext();
        springMvcContext.register(MvcConfig.class);
        //DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springMvcContext);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        dynamic.setLoadOnStartup(1);
        dynamic.addMapping("/");
        //配置字符集为utf-8
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        FilterRegistration filterRegistration = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/");
    }
}
