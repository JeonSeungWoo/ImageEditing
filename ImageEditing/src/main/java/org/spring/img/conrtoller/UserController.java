package org.spring.img.conrtoller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.img.domain.UserVO;
import org.spring.img.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.protobuf.ByteString.Output;

@RequestMapping("/user/*")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Inject // byType으로 자동 주입
	UserService service;

	// 로그인 폼을 띄우는 부분
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() throws Exception {
		logger.info("loginForm");

		return "/user/loginForm"; // /login/loginForm.jsp를 띄움.
	}// end of loginForm

	// 로그인 처리하는 부분
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpSession session, UserVO dto, Model model) throws Exception {
		String returnURL = "";

		logger.info("userVO ::::::  " + dto);

		if (session.getAttribute("login") != null) {
			// 기존에 login이란 세션 값이 존재한다면
			session.removeAttribute("login"); // 기존값을 제거해 준다.
		}

		// 로그인이 성공하면 UserVO 객체를 반환함.
		UserVO vo = service.login(dto);

		if (vo != null) { // 로그인 성공
			session.setAttribute("login", vo); // 세션에 login인이란 이름으로 UserVO 객체를 저장해 놈.
			logger.info("여기까지");
			returnURL = "redirect:/user/loginConfirm?check=1"; // 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
		} else { // 로그인에 실패한 경우
			returnURL = "redirect:/user/loginConfirm?check=0"; // 로그인 폼으로 다시 가도록 함
		}
		logger.info("return 확인 : " + returnURL);
		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴
	}

	// 로그아웃 하는 부분
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("login");
		session.invalidate(); // 세션 전체를 날려버림
		
		
		return "redirect:/"; // 로그아웃 후 게시글 목록으로 이동하도록...함
	}

	// 오그인 성공 실패 체크
	@RequestMapping(value = "/loginConfirm", method = RequestMethod.GET)
	public String loginConfirm(@RequestParam("check") int check, Model model) throws Exception {
		logger.info("check   : " + check);
		return "/user/loginConfirm";
	}

	// 회원가입FORM
	@RequestMapping(value = "/loginCreatePage", method = RequestMethod.GET)
	public String loginCreatePage(Model model) throws Exception {
		logger.info("등록 페이지");

		return "/user/loginCreatePage";
	}

	@RequestMapping(value = "/loginCreate", method = RequestMethod.POST)
	public String loginCreate(Model model, UserVO vo) throws Exception {

		service.loginCreate(vo);

		return "redirect:/user/login";
	}

	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	public void checkId(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		PrintWriter out = res.getWriter();
		
		try {
			String parmid = (req.getParameter("userId")== null)? "" : String.valueOf(req.getParameter("userId"));
			
  			UserVO vo = new UserVO();
  			vo.setUserId(parmid.trim());
  			logger.info("123 " + vo);
  			Integer checkPoint = service.checkId(vo);
  			
  			out.print(checkPoint);
  			out.flush();
  			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print("1");
			
		}

	}

	
	
	
	
	
	
	
	
	
	
	
}
