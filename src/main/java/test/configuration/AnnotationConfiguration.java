package test.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = {"test"})
@PropertySource("classpath:application.yml")
public class AnnotationConfiguration {
}
