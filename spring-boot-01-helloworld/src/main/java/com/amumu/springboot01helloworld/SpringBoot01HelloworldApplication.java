package com.amumu.springboot01helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 下方注解说明这是一个springboot主程序，必需的
 * */
@SpringBootApplication
public class SpringBoot01HelloworldApplication {

	public static void main(String[] args) {
		//下面就是启动spring应用,就可以开始配置程序了
		SpringApplication.run(SpringBoot01HelloworldApplication.class, args);
	}

}
