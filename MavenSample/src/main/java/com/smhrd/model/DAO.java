package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class DAO {
	// sql세션을 생성해 줄 factory 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	// factory를 사용해서 sql세션(sql실행, close(), 연결(connection)) 생성
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	// 회원가입
	public int join(VO vo) {
		
		int cnt =0;
		try { // 만약 sql문이 잘못됬다거나, url이 잘못되었다던가하면 세션이 잘 생성 안될 수 있음
			
			// insert( "실행할 sql 경로 정의" , 넘겨줄 값 )
			cnt = sqlSession.insert("com.smhrd.model.DAO.insert", vo);
			
			if(cnt > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
		
	}
		
	public String login(VO vo) {
		String name = null;
		try {
			 name = sqlSession.selectOne("com.smhrd.model.DAO.selectOne",vo);
			// select - commit/ rollback 생략 가능
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return name;
		
	}
	
	
	
	
	
}
