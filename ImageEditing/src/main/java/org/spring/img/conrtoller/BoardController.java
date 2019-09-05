package org.spring.img.conrtoller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.img.domain.BoardVO;
import org.spring.img.domain.Criteria;
import org.spring.img.domain.Paging;
import org.spring.img.domain.UserVO;
import org.spring.img.service.BoardService;
import org.spring.img.service.ImgService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/board/*")
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	@Inject
	private ImgService imgService;

	@RequestMapping(value = "/insertPage", method = RequestMethod.GET)
	public void insertPage(Model model, UserVO vo, HttpSession session) throws Exception {
		logger.info("test!!!!!!!!!!!!! : " + session.getAttribute("userId"));

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(Model model, BoardVO vo, @RequestParam("file") List<MultipartFile> file) throws Exception {
		// ¿ÃπÃ¡ˆ

		service.create(vo, file);

		return "redirect:/board/listPage?page=1";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readPage(Model model, @RequestParam("bno") int bno) throws Exception {

		model.addAttribute("list", imgService.imgList(bno));

		model.addAttribute("vo", service.read(bno));

	}

	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public void updatePage(Model model, Integer bno) throws Exception {

		model.addAttribute("list", imgService.imgList(bno));
		model.addAttribute("vo", service.read(bno));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model, BoardVO vo) throws Exception {

		logger.info("update Test ::   ");

		service.update(vo);

		return "redirect:/board/listPage?page=1";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model, int bno) throws Exception {

		service.delete(bno);

		return "redirect:/board/listPage?page=1";

	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listAll(Model model, Criteria cri, Integer page) throws Exception {

		model.addAttribute("list", service.list(cri));
		model.addAttribute("Paging", new Paging(page, service.listCount()));

	}

	@RequestMapping(value = "/userListPage", method = RequestMethod.GET)
	public void userListPage(Model model, Criteria cri, Integer page, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userId");
		String userId = obj.toString();
		cri.setUserId(userId);
		model.addAttribute("list", service.userlist(cri));
		model.addAttribute("Paging", new Paging(page, service.userlistCount()));

	}

	
	
	
}
