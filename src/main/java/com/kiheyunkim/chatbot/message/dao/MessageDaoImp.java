package com.kiheyunkim.chatbot.message.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kiheyunkim.chatbot.message.model.Message;

public class MessageDaoImp implements MessageDao{

	private final SessionFactory sessionFactory;
	
	public MessageDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public String getAnswer(String question) {
		Session session = sessionFactory.openSession();
		
		try {
			Message result = session.get(Message.class, question);
			return result.getMessage();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean setMessage(String question, String answer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			tx.begin();
			Message result = session.get(Message.class, question);
			if(result != null) {
				throw new Exception();
			}			
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
