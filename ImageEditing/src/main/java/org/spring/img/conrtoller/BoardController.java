package org.spring.img.conrtoller;

import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.img.domain.BoardVO;
import org.spring.img.domain.Criteria;
import org.spring.img.domain.ImgVO;
import org.spring.img.domain.Paging;
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
	public void insertPage(Model model) throws Exception {
		logger.info("test!!!!!!!!!!!!!");
		

	}
    
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(Model model, BoardVO vo,
			@RequestParam("file") List<MultipartFile> file) throws Exception {
		logger.info("insert sccess!!!!");
		logger.info("vo  :: " +  vo); 
		
		
	
		//이미지 
		
		service.create(vo,file);
		
		

		return "redirect:/board/listPage?page=1";
	}

	
	
	
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readPage(Model model, @RequestParam("bno") int bno) throws Exception {
		
		logger.info("tsetSHow   ::   " + imgService.imgList(bno));
		
		model.addAttribute("list",imgService.imgList(bno)); 	
		
		model.addAttribute("vo", service.read(bno));
		
	}

	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public void updatePage(Model model,@RequestParam("bno")int bno) throws Exception {
	
		model.addAttribute("vo", service.read(bno));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model,BoardVO vo,int page) throws Exception {

		
		service.update(vo);
		
		return "redirect:/board/listPage?page="+page;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model,@RequestParam("bno")int bno,int page) throws Exception {

		service.delete(bno);
		
		return "redirect:/board/listPage?page="+page;
		
	}
	

	
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void liatAll(Model model ,Criteria cri,Integer page) throws Exception {
	    System.out.println("list 입니다!!!!" + service.list(cri));
	    model.addAttribute("list",service.list(cri)); 		
		model.addAttribute("Paging",new Paging(page, service.listCount()));
		
	}

}
