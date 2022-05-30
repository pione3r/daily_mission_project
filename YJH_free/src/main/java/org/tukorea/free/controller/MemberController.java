package org.tukorea.free.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.free.domain.MemberVO;
import org.tukorea.free.domain.MissionVO;
import org.tukorea.free.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired(required=true)
	private MemberService memberService;
	
	@RequestMapping(value = {"/read"}, method = RequestMethod.GET)
	public String readMember(@RequestParam("id") String id, Model model) throws Exception {
		MemberVO member = memberService.readMember(id);
		logger.info(" /read?id=" + id + " URL called. then readMember method executed.");
		model.addAttribute("member", member);
		
		return "member/member_read";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyMemberGet(HttpServletRequest req, Model model) throws Exception {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("member");
		
		MemberVO member = memberService.readMember(id);
		
		logger.info(" /modify?id=" + id + " URL GET method called. then forward member_modify.jsp.");
		model.addAttribute("member", member);
		
		return "member/member_modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyMemberPost(@ModelAttribute("member") MemberVO vo) throws Exception {
		memberService.updateMember(vo);
		
		logger.info(vo.toString());
		logger.info("/modify?id=" + vo.getId() + " URL POST method called. then modifyMemberPost executed.");
		
		return "redirect:/mission/list";
	}

}

