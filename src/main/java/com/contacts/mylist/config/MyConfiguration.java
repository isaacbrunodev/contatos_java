package com.contacts.mylist.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
