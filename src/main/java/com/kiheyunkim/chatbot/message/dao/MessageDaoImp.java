package com.kiheyunkim.chatbot.message.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.kiheyunkim.chatbot.message.model.Message;

@Repository
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
		finally {
			session.close();
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
			tx.rollback();
			return false;
		}
		finally {
			session.close();
		}
	}
}
