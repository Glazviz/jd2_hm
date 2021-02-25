package it.academy.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "it.academy", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = AddDuringScan.class))

public class SpringConfig {
}
