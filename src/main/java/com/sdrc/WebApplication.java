package com.sdrc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer 
{
	@Autowired
    private ApplicationContext appContext;
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    
    
    public static void main(String[] args) throws Exception {
    	System.out.println("****************************************************************");
        SpringApplication.run(WebApplication.class, args);
    }
    
    /*@Override
    public void run(String... args) throws Exception {

        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println("bean=                                       "+bean);
        }
        System.out.println("appContext.getApplicationName()= "+appContext.getApplicationName());
        System.out.println("appContext.getDisplayName()= "+appContext.getDisplayName());
        System.out.println("appContext.getId()= "+appContext.getId());
        System.out.println("appContext.getEnvironment()= "+appContext.getEnvironment());
        System.out.println("appContext.getParent()= "+appContext.getParent());
        System.out.println("appContext.getStartupDate()= "+appContext.getStartupDate());
        System.out.println("appContext.toString()= "+appContext.toString());

    }*/
}
