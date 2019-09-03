package org.spring.img.conrtoller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.img.domain.ImgVO;
import org.spring.img.service.ImgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/upload/*")
@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	
	@Inject
	private ImgService imgService;
	
	//대표이미지 보여주기
	@SuppressWarnings("unused")
	@RequestMapping(value = "/show")
	public @ResponseBody byte[] show(@RequestParam("bno")int bno)throws Exception{
		
		InputStream in;
		String location = "";
		String fileName = "";
		String noImg = "C:\\TEMP\\noImage.png";
		if(imgService.imgReadPage(bno) != null) {
			location = imgService.imgReadPage(bno).getLocation();
			fileName = imgService.imgReadPage(bno).getFileName();
			in = new FileInputStream(location + fileName);
		}else {
			in = new FileInputStream(noImg);
		
		}
	
		return IOUtils.toByteArray(in);
		
		
	}
	
	//대표이미지 보여주기
	@SuppressWarnings({ "unused", "resource" })
	@RequestMapping(value = "/showAll")
	public @ResponseBody byte[] showAll(@RequestParam("bno")int bno,@RequestParam("fileName")String fileName)throws Exception{
		
		logger.info("test : " + imgService.imgReadAll(bno, fileName));
		
		InputStream in;
		String location = "";
		String noImg = "C:\\TEMP\\noImage.png";
		
		if(imgService.imgReadAll(bno, fileName) != null) {
			location = imgService.imgReadAll(bno, fileName).getLocation();
			in = new FileInputStream(location + fileName);
		}else {
			in = new FileInputStream(noImg);
		
		}
	
		return IOUtils.toByteArray(in);
     
	}

	
}
