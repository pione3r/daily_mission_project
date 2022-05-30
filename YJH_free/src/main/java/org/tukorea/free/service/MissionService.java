package org.tukorea.free.service;

import java.util.List;

import org.tukorea.free.domain.MissionVO;

public interface MissionService {
	public MissionVO readMission(String missionname) throws Exception;
	public List<MissionVO> readMissionList(String id) throws Exception;
	public List<MissionVO> readByMissionList(String missionname) throws Exception;
	public void addMission(MissionVO mission) throws Exception;
	public void deleteMission(int mission_id) throws Exception;
	public void updateMission(MissionVO mission) throws Exception;
	public void deleteAddTransactionMission(int mission_id, MissionVO mission) throws Exception;
}