package com.bokaro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages ="com.bokaro.repository" )
@EntityScan(basePackages = "com.bokaro.entity")
public class Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }*/

//	public String getURLBase(HttpServletRequest request) throws MalformedURLException {
//
//	    URL requestURL = new URL(request.getRequestURL().toString());
//	    String port = requestURL.getPort() == -1 ? "" : ":" + requestURL.getPort();
//	    return requestURL.getProtocol() + "://" + requestURL.getHost() + port;
//
//	}
}
	