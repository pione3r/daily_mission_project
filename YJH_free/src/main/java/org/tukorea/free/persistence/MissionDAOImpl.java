package org.tukorea.free.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.free.domain.MissionVO;

@Repository
public class MissionDAOImpl implements MissionDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.free.mapper.MissionMapper";
	
	public MissionVO read(String missionname) throws Exception {
		MissionVO vo = sqlSession.selectOne(namespace + ".selectByid", missionname);
		
		return vo;
	}
	
	public List<MissionVO> readList(String id) throws Exception {
		List<MissionVO> missionlist = new ArrayList<MissionVO>();
		missionlist = sqlSession.selectList(namespace + ".selectAll");
		
		return missionlist;
	}
	
	public List<MissionVO> readByMissionName(String missionname) throws Exception {
		List<MissionVO> missionlist = new ArrayList<MissionVO>();
		missionlist = sqlSession.selectList(namespace + ".selectByMissionname", missionname);
		
		return missionlist;
	}
	
	public void add(MissionVO vo) throws Exception {
		sqlSession.insert(namespace + ".insert", vo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout = 10)
	public void delete(int mission_id) throws Exception {
		sqlSession.delete(namespace + ".delete", mission_id);
	}
	
	public void update(MissionVO mission) throws Exception {
		sqlSession.update(namespace + ".update", mission);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout = 10)
	public void deleteToAddTransaction(int mission_id, MissionVO mission) throws Exception {
		sqlSession.delete(namespace + ".delete", mission_id);
		sqlSession.update(namespace + ".insert", mission);
	}
	
}