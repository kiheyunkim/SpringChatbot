package com.kiheyunkim.chatbot.config;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.kiheyunkim.chatbot.message.dao.MessageDao;
import com.kiheyunkim.chatbot.message.dao.MessageDaoImp;
import com.kiheyunkim.chatbot.message.model.Message;

@Configuration
public class ChatbotBeanConfiguration {

	@Bean
	public MessageDao messageDao(SessionFactory sessionFactory) {
		return new MessageDaoImp(sessionFactory);
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		localSessionFactoryBean.setAnnotatedClasses(Message.class);
		return localSessionFactoryBean;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put(AvailableSettings.URL, "jdbc:mysql://localhost:3306/chatbotMsg?characterEncoding=UTF-8&serverTimezone=UTC");
		properties.put(AvailableSettings.USER, "root");
		properties.put(AvailableSettings.PASS, "920kImkh223!");
		properties.put(AvailableSettings.DIALECT,MySQL5Dialect.class.getName());
		properties.put(AvailableSettings.SHOW_SQL,String.valueOf(true));
		properties.put(AvailableSettings.HBM2DDL_AUTO, "update");
		return properties;
	}
}
