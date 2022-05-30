package org.tukorea.free.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.free.domain.MissionVO;
import org.tukorea.free.service.MissionService;

@Controller
@RequestMapping(value="/mission")
public class MissionController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MissionController.class);
	
	@Autowired(required=true)
	private MissionService missionService;
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String listMission(Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("member");
		
		List<MissionVO> missions = missionService.readMissionList(id);
		
		logger.info(" /mission/list URL called. then listMission method executed.");
		model.addAttribute("missions", missions);
		
		return "mission/mission_list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String readMission(@RequestParam("missionname") String missionname, Model model) throws Exception {
		MissionVO mission = missionService.readMission(missionname);
		
		logger.info(" /read?missionname=" + missionname + " URL callded. then readMission method executed.");
		model.addAttribute("mission", mission);
		
		return "mission/mission_read";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String createMissionGet() throws Exception {
		logger.info(" /register URL GET method called. then forward mission_register.jsp");
		

		
		return "mission/mission_register";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String createMissionPost(@ModelAttribute("mission") MissionVO vo, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("member");
		vo.setId(id);
		missionService.addMission(vo);
		
		
		logger.info(vo.toString());
		logger.info(" /register URL POST method called. then createMission method executed.");
		
		return "redirect:/mission/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyMissionGet(@RequestParam("missionname") String missionname, Model model, HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("member");
		List<MissionVO> missions = missionService.readByMissionList(missionname);
		for(MissionVO vo : missions) {
	    	System.out.println(vo.getId().equals(id) && vo.getMissionname().equals(missionname));
		    if(vo.getId().equals(id) && vo.getMissionname().equals(missionname)){
		    	model.addAttribute("mission", vo);
		    }
		}
		
		logger.info(" /modify?missionname=" + missionname + " URL GET method called. then forward mission_modify.jsp.");
		
		
		return "mission/mission_modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyMissionPost(@ModelAttribute("mission") MissionVO vo) throws Exception {
		missionService.updateMission(vo);
		
		logger.info(vo.toString());
		logger.info("/modify?missionname=" + vo.getMissionname() + " URL POST method called. then modifyMissionPost executed.");
		
		return "redirect:/mission/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteMember(@RequestParam("mission_id") int mission_id) throws Exception {
		missionService.deleteMission(mission_id);
		logger.info(" deleteMission excuted");
		
		return "redirect:/mission/list";
	}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logout(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		session.invalidate();
		
		logger.info(" /logout URL GET method called. then logout method executed.");
		
		return "redirect:/login";
	}
	
	@RequestMapping(value = {"/addto"}, method = RequestMethod.GET)
	public String addToMissionPost() throws Exception {
		logger.info(" /addto URL GET method called.");
		

		
		return "mission/mission_addto";
	}
	
	@RequestMapping(value = {"/addto"}, method = RequestMethod.POST)
	public String addToMissionGet(@ModelAttribute("mission") MissionVO vo, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("member");
		vo.setId(id);
		missionService.addMission(vo);
		
		
		logger.info(vo.toString());
		logger.info(" /addto URL POST method called. then method executed.");
		
		return "redirect:/mission/list";
	}
	
	
}