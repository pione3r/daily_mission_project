package org.tukorea.free.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.free.domain.MemberVO;
import org.tukorea.free.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}
	
	public void addMember(MemberVO member) throws Exception {
		memberDAO.add(member);
	}
	
	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);
	}
	
	public void updateMember(MemberVO member) throws Exception {
		memberDAO.update(member);
	}
}