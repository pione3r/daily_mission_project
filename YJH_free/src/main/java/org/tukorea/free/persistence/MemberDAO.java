package org.tukorea.free.persistence;

import org.tukorea.free.domain.MemberVO;

public interface MemberDAO {
	public MemberVO read(String id) throws Exception;
	public void add(MemberVO member) throws Exception;
	public void delete(String id) throws Exception;
	public void update(MemberVO member) throws Exception;
	public boolean logincheck(String id, String pw) throws Exception;
	
	
}