package com.kiheyunkim.chatbot.config;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ServletConfiguration implements ServletContainerInitializer{

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext =
				new AnnotationConfigWebApplicationContext();
	}

}
