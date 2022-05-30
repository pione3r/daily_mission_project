package org.tukorea.free.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.free.domain.MemberVO;
import org.tukorea.free.domain.MissionVO;
import org.tukorea.free.service.MemberService;
import org.tukorea.free.service.MissionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TransactionTest {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MissionService missionService;
	
	@Test
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout = 10)
	public void testDeleteAdd() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("tran"); member.setPasswd("tran"); member.setUsername("tran"); member.setMobile("tran"); member.setEmail("tran");
		memberService.addMember(member);
		
		MissionVO vo = new MissionVO();
		vo.setId("tran"); vo.setMissionname("tran"); vo.setGoal("tran"); vo.setReward("tran");
		
		missionService.addMission(vo);
		
		missionService.deleteAddTransactionMission(vo.getMission_id(), vo);
		
		
	}
}