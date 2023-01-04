package com.smhrd.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class MessageDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	public int insertMessage(MessageVO vo) {
		int cnt = 0;
		try {
			cnt = sqlSession.insert("com.smhrd.domain.MessageDAO.insertMessage", vo);
			if(cnt>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	public List<MessageVO> selectAll(String email) {
		List<MessageVO> messageList = null;
		
		try {
			messageList = sqlSession.selectList("com.smhrd.domain.MessageDAO.selectAll", email);
			if(messageList!=null) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}finally {
			sqlSession.close();
		}
		return messageList;
	}
	
	public int deleteMessage(int num) {
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.smhrd.domain.MessageDAO.deleteMessage",num);

			if(cnt>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	public int deleteMessageAll(String email) {
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.smhrd.domain.MessageDAO.deleteMessageAll",email);

			if(cnt>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
}
