package org.tukorea.free.domain;

public class MissionVO {
	private String id;
	private String missionname;
	private String goal;
	private String reward;
	private int mission_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMissionname() {
		return missionname;
	}
	public void setMissionname(String missionname) {
		this.missionname = missionname;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	
	public int getMission_id() {
		return mission_id;
	}
	public void setMission_id(int mission_id) {
		this.mission_id = mission_id;
	}
	@Override
	public String toString() {
		return "MissionVO [id=" + id + ", missionname=" + missionname + ", goal=" + goal + ", reward=" + reward
				+ ", mission_id=" + mission_id + "]";
	}

	
	
}