package org.tukorea.free.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.free.mapper.MemberMapper";
	
	public MemberVO read(String id) throws Exception {
		MemberVO vo = sqlSession.selectOne(namespace + ".selectByid", id);
		
		return vo;
	}
	
	public void add(MemberVO vo) throws Exception {
		sqlSession.insert(namespace + ".insert", vo);
	}
	
	public void delete(String id) throws Exception {
		sqlSession.delete(namespace + ".delete", id);
	}
	
	public void update(MemberVO member) throws Exception {
		sqlSession.update(namespace + ".update", member);
	}
	
	public boolean logincheck(String id, String pw) throws Exception {
		MemberVO vo = sqlSession.selectOne(namespace + ".selectByid", id);
		
		System.out.println(vo);
		
		if (vo == null) return false;
		if (vo.getPasswd().equals(pw)) return true;
		else return false;
	}
}