package org.tukorea.free.service;

import org.tukorea.free.domain.MemberVO;

public interface MemberService {
	public MemberVO readMember(String id) throws Exception;
	public void addMember(MemberVO member) throws Exception;
	public void deleteMember(String id) throws Exception;
	public void updateMember(MemberVO member) throws Exception;
}