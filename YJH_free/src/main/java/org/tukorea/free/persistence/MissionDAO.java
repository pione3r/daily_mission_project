package org.tukorea.free.persistence;

import java.util.List;

import org.tukorea.free.domain.MissionVO;

public interface MissionDAO {
	public MissionVO read(String missionname) throws Exception;
	public List<MissionVO> readList(String id) throws Exception;
	public List<MissionVO> readByMissionName(String missionname) throws Exception;
	public void add(MissionVO mission) throws Exception;
	public void delete(int mission_id) throws Exception;
	public void update(MissionVO mission) throws Exception;
	public void deleteToAddTransaction(int mission_id, MissionVO mission) throws Exception;
}