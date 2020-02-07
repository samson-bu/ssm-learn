package self.samson.ssm.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.xml.ws.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@ComponentScan(basePackages = {"self.samson.ssm.learn.controller", "self.samson.ssm.learn.service"})
@Configuration
@EnableWebMvc
public class SpringWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

//    @Bean("adapter1")
//    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
//        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
//        requestMappingHandlerAdapter.setWebBindingInitializer(customBinder());
//
//        return requestMappingHandlerAdapter;
//    }
//
//    @Bean
//    public ConfigurableWebBindingInitializer customBinder() {
//        ConfigurableWebBindingInitializer configurableWebBindingInitializer = new ConfigurableWebBindingInitializer();
//        configurableWebBindingInitializer.setConversionService(conversionService().getObject());
//        return configurableWebBindingInitializer;
//    }
//
//    @Bean
//    public FormattingConversionServiceFactoryBean conversionService() {
//
//        Set<Converter> converters = new HashSet<>();
//        converters.add(new CustomDateConverter());
//
//        FormattingConversionServiceFactoryBean factoryBean = new FormattingConversionServiceFactoryBean();
//        factoryBean.setConverters(converters);
//
//        return factoryBean;
//    }
//
//    private class CustomDateConverter implements Converter<String, Date> {
//        @Override
//        public Date convert(String source) {
//
//            try{
//                return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse(source);
//            }catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//    }
}
