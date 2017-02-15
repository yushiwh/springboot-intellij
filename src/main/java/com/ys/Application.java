package com.ys;

import com.ys.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
public class Application {
	 @Value("${author.age}")
	 private String bookAuthor;
	 @Value("${author.name}")
	 private String bookName;

	@Autowired
	PersonRepository personRepository;

	 @RequestMapping("/")
	    String index() {
			System.out.println("测试一下后台的输出");
	        return "book name is:"+bookName+" and book author is:" + bookAuthor;
	    }



	public static void main(String[] args) {
         SpringApplication.run(Application.class, args);

    }
}
