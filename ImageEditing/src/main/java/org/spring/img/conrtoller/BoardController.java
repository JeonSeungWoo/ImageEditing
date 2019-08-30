package org.spring.img.conrtoller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.img.HomeController;
import org.spring.img.domain.BoardVO;
import org.spring.img.domain.Criteria;
import org.spring.img.domain.Paging;
import org.spring.img.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/board/*")
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	@RequestMapping(value = "/insertPage", method = RequestMethod.GET)
	public void insertPage(Model model) throws Exception {
		logger.info("test!!!!!!!!!!!!!");

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(Model model, BoardVO vo) throws Exception {
		service.create(vo);
		logger.info("insert sccess!!!!");

		return "redirect:/board/listPage?page=1";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readPage(Model model, @RequestParam("bno") int bno) throws Exception {
		logger.info("Rcall!");
		model.addAttribute("vo", service.read(bno));
		
		logger.info("ReadList :: " + service.read(bno));
	}

	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public void updatePage(Model model,@RequestParam("bno")int bno) throws Exception {
		logger.info("UPcall!");
		model.addAttribute("vo", service.read(bno));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model,BoardVO vo,int page) throws Exception {
		logger.info("Ucall!");
		logger.info("updateTest ::" + vo);
		
		service.update(vo);
		
		return "redirect:/board/listPage?page="+page;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model,@RequestParam("bno")int bno,int page) throws Exception {
		logger.info("Dcall!");
		service.delete(bno);
		
		return "redirect:/board/listPage?page="+page;
		
	}
	
	
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void liatAll(Model model ,Criteria cri,Integer page) throws Exception {
		logger.info("Licall!");
		logger.info("Cri :: " + cri  + "  page ::  " + page);
		model.addAttribute("Paging",new Paging(page, service.listCount()));
		logger.info("list22 ::!" + new Paging(page, service.listCount()));
		model.addAttribute("list",service.list(cri)); 
		logger.info("list ::!" + service.list(cri));
		
		
		 
		 
	
	}

}
