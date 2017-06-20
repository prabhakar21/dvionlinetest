package com.bokaro;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/home").setViewName("home");
	        registry.addViewController("/").setViewName("index");
	        registry.addViewController("/hello").setViewName("hello");
	        registry.addViewController("/admin").setViewName("admin");
	        registry.addViewController("/user").setViewName("user");
	        registry.addViewController("/index").setViewName("index");
	        registry.addViewController("/login").setViewName("login");
	        registry.addViewController("/403").setViewName("403");
	    }   
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	}
	    
//	    @Bean
//		public InternalResourceViewResolver viewResolver() {
//			InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//			resolver.setPrefix("/WEB-INF/jsp/");
//			resolver.setSuffix(".jsp");
//			return resolver;
//		}   
	    @Bean
	    public MessageSource messageSource() {
	         ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	         messageSource.setBasename("/WEB-INF/i18n/messages");
	         return messageSource;
	    }
}