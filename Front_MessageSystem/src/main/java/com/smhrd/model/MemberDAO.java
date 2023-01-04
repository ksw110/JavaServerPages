package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class MemberDAO {

	// DAO에서 호출했을 때 바로 DB와 연결할 수 있도록 SqlSessionManager사용
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	// 아래 메소드들에서 사용할 수 있는 sqlSession 생성
	SqlSession sqlSession = sqlSessionFactory.openSession();

	public int insertMember(MemberVO vo) {
		int cnt = 0;

		try { // 만약 sql문이 잘못됐다거나, url이 잘못되었다던가하면 세션이 잘 생성이 안될 수도 있음

			// insert("실행할 sql 경로 정의", 넘겨줄 값)
			cnt = sqlSession.insert("com.smhrd.model.MemberDAO.insertMember", vo);

			if (cnt > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;
	}
	
	public MemberVO selectMember(MemberVO vo) {
		MemberVO loginMember = null;
		try {
			loginMember = sqlSession.selectOne("com.smhrd.model.MemberDAO.selectOne", vo);
			// commit / rollback 생략
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return loginMember;
	}
	
	public int updateMember(MemberVO vo) {
		int cnt = 0;

		try { // 만약 sql문이 잘못됐다거나, url이 잘못되었다던가하면 세션이 잘 생성이 안될 수도 있음

			// insert("실행할 sql 경로 정의", 넘겨줄 값)
			cnt = sqlSession.update("com.smhrd.model.MemberDAO.updateMember", vo);

			if (cnt > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;
		
	}
	
	public List<MemberVO>  selectAllMember() {
		List<MemberVO> list = null;
		try {
			list = sqlSession.selectList("com.smhrd.model.MemberDAO.selectAllMember");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return list;
		
	}
	public int deleteMember(String email) {
		int cnt = 0;
		try {
			cnt =sqlSession.delete("com.smhrd.model.MemberDAO.deleteMember", email);
			if (cnt > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	public boolean emailCheck(String inputE) {
		
		boolean checkE = false;
		try {
			checkE =sqlSession.selectOne("com.smhrd.model.MemberDAO.emailCheck", inputE);
			

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return checkE;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
