package org.tukorea.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.free.domain.MissionVO;
import org.tukorea.free.persistence.MissionDAO;

@Service
public class MissionServiceImpl implements MissionService {
	@Autowired
	private MissionDAO missionDAO;
	
	public MissionVO readMission(String missionname) throws Exception {
		return missionDAO.read(missionname);
	}
	
	public List<MissionVO> readMissionList(String id) throws Exception {
		return missionDAO.readList(id);
	}
	
	public List<MissionVO> readByMissionList(String missionname) throws Exception {
		return missionDAO.readByMissionName(missionname);
	}

	
	public void addMission(MissionVO mission) throws Exception {
		missionDAO.add(mission);
	}
	
	public void deleteMission(int mission_id) throws Exception {
		missionDAO.delete(mission_id);
	}
	
	public void updateMission(MissionVO mission) throws Exception {
		missionDAO.update(mission);
	}
	
	public void deleteAddTransactionMission(int mission_id, MissionVO mission) throws Exception {
		missionDAO.deleteToAddTransaction(mission_id, mission);
	}
}