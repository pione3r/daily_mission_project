package org.tukorea.free.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
import org.tukorea.free.domain.MemberVO;
import org.tukorea.free.persistence.MemberDAO;
import org.tukorea.free.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	MemberDAO memberDAO;
	
	@Autowired
	MemberService memberService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "login";
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String loginGet() throws Exception {
		logger.info("login GET Method executed.");

		return "login";
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String loginPost(@ModelAttribute("member") MemberVO vo, HttpServletRequest req) throws Exception {
		logger.info("login POST Method executed.");
				
		HttpSession session = req.getSession();
		
		if(memberDAO.logincheck(vo.getId(), vo.getPasswd())) {
			
			session.setAttribute("member", vo.getId());
			session.setAttribute("loginFail", false);
			
			return "redirect:/mission/list";
		}
		else {
			session.setAttribute("loginFail", true);
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String createMemberGet() throws Exception {
		logger.info(" /register URL GET mthod called. then forward mission_register.jsp");
		
		return "member/member_register";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String createMemberPost(@ModelAttribute("member") MemberVO vo) throws Exception {
		memberService.addMember(vo);
		
		logger.info(vo.toString());
		logger.info(" /register URL Post method called. then createMission method executed.");
		
		return "redirect:/login";
	}
	
}
