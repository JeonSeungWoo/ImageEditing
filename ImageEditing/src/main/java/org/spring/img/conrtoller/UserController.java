package org.spring.img.conrtoller;

import java.io.PrintWriter;

import javax.inject.Inject;
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

@RequestMapping("/user/*")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Inject // byType���� �ڵ� ����
	UserService service;

	// �α��� ���� ���� �κ�
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() throws Exception {
	

		return "/user/loginForm"; // /login/loginForm.jsp�� ���.
	}// end of loginForm

	// �α��� ó���ϴ� �κ�
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpSession session, UserVO dto, Model model) throws Exception {
		String returnURL = "";

		if (session.getAttribute("login") != null) {
			// ������ login�̶� ���� ���� �����Ѵٸ�
			session.removeAttribute("login"); // �������� ������ �ش�.
		}

		// �α����� �����ϸ� UserVO ��ü�� ��ȯ��.
		UserVO vo = service.login(dto);

		if (vo != null) { // �α��� ����
			session.setAttribute("login", vo); // ���ǿ� login���̶� �̸����� UserVO ��ü�� ������ ��.
			session.setAttribute("userId", vo.getUserId());
		
			returnURL = "redirect:/user/loginConfirm?check=1"; // �α��� ������ �Խñ� ����������� �ٷ� �̵��ϵ��� �ϰ�
		} else { // �α��ο� ������ ���
			returnURL = "redirect:/user/loginConfirm?check=0"; // �α��� ������ �ٽ� ������ ��
		}
		logger.info("return Ȯ�� : " + returnURL);
		return returnURL; // ������ ������ returnURL �� ��ȯ�ؼ� �̵���Ŵ
	}

	// �α׾ƿ� �ϴ� �κ�
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("login");
		session.invalidate(); // ���� ��ü�� ��������
		
		
		return "redirect:/"; // �α׾ƿ� �� �Խñ� ������� �̵��ϵ���...��
	}

	// ������ ���� ���� üũ
	@RequestMapping(value = "/loginConfirm", method = RequestMethod.GET)
	public String loginConfirm(@RequestParam("check") int check, Model model) throws Exception {

		return "/user/loginConfirm";
	}

	// ȸ������FORM
	@RequestMapping(value = "/loginCreatePage", method = RequestMethod.GET)
	public String loginCreatePage(Model model) throws Exception {


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
  			Integer checkPoint = service.checkId(vo);
  			
  			out.print(checkPoint);
  			out.flush();
  			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print("1");
			
		}

	}

	@RequestMapping(value = "/userInfo" )
	public void userInfo(HttpServletRequest request,Model model)throws Exception{
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userId");
		String userId = obj.toString();
		System.out.println("vo  : " + service.userInfo(userId));
		
		model.addAttribute("info",service.userInfo(userId));
		
		
	}
	
	
	@RequestMapping(value = "/userUpdate")
	public String userUpdate(UserVO vo)throws Exception{
		System.out.println("vo   :  " + vo);
		service.userUpdate(vo);
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
