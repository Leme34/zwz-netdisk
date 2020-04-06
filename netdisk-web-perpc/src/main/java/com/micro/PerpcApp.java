package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

@SpringBootApplication
@EnableDubboConfiguration
@NacosPropertySource(dataId = "netdisk-web-perpc",groupId="netdisk",autoRefreshed=true)
public class PerpcApp {
	
	public static void main(String[] args) {
		SpringApplication.run(PerpcApp.class, args);
	}
}

//排除内置Tomcat
/*@SpringBootApplication
@EnableDubboConfiguration
@NacosPropertySource(dataId = "netdisk-web-perpc",groupId="netdisk",autoRefreshed=true)
public class PerpcApp extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PerpcApp.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PerpcApp.class, args);
	}
}
*/