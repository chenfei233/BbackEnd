package com.cf.bbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class BbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbackendApplication.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 设置文件大小限制 ,超出设置页面会抛出异常信息，
		// 这样在文件上传的地方就需要进行异常信息的处理了;
		factory.setMaxFileSize("256KB"); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("512KB");
		factory.setLocation("D:/image");
		return factory.createMultipartConfig();
	}
}
