package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HajibootApplication {

	@GetMapping("/")
	String home(@RequestParam(name = "firstname", required = false, defaultValue = "") String first_name, @RequestParam(name = "lastname", required = false, defaultValue = "") String last_name) {
    String message = "<h1>Hello";
		if(first_name.isEmpty() && last_name.isEmpty()){
			return "<h1>Hello World!</h1>";
		}else{
      message = message + first_name;
      if(!first_name.isEmpty() && !last_name.isEmpty()){
        message = message + " ";
      }
			message = message + last_name;
		}
    message = message + "!</h1>";
    return  message;
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootApplication.class, args);
	}

}
