package com.smhrd.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	public int insertMember(MemberVO vo) {
		int cnt = 0;
		try {
			cnt = sqlSession.insert("com.smhrd.domain.MemberDAO.insertMember", vo);
			if(cnt>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	public MemberVO selectMember(MemberVO member) {
		MemberVO loginMember = null;

		try {
			loginMember = (MemberVO)sqlSession.selectOne("com.smhrd.domain.MemberDAO.selectMember", member);
			if(loginMember!=null) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}finally {
			sqlSession.close();
		}
		return loginMember;
	}
	
	public int updateMember(MemberVO member) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("com.smhrd.domain.MemberDAO.updateMember", member);
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
	
	public List<MemberVO> selectAll() {
		List<MemberVO> memberList = null;
		
		try {
			memberList = sqlSession.selectList("com.smhrd.domain.MemberDAO.selectAll");
			if(memberList!=null) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}finally {
			sqlSession.close();
		}
		return memberList;
	}
	
	public int deleteMember(String email) {
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.smhrd.domain.MemberDAO.deleteMember", email);

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
	
	public boolean emailCheck(String inputE) {
		boolean checkE = false;

		try {
			checkE = (boolean)sqlSession.selectOne("com.smhrd.domain.MemberDAO.emailCheck", inputE);

		}finally {
			sqlSession.close();
		}
		return checkE;
	}
}
