package com.lhl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Created by lenovo on 2016/3/17.
 */
@Configuration
@ComponentScan(basePackages = "com.lhl.mvc",
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = {Controller.class}
                )
        }
)
public class AppConfig {
}
