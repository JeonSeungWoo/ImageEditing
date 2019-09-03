package org.spring.img.conrtoller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.img.domain.ImgVO;
import org.spring.img.service.ImgService;
import org.spring.img.util.UploadFileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
		byte[] result = IOUtils.toByteArray(in);
		in.close();
		return result;
		
	}
	
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
		byte[] result = IOUtils.toByteArray(in);
		in.close();
		return result;
     
	}
	
	@RequestMapping(value = "/imgDelete")
	public String imgDelete(int bno,String fileName )throws Exception{
		logger.info("test : " + imgService.imgReadAll(bno, fileName));
	      	String location = imgService.imgReadAll(bno, fileName).getLocation();
			File file = new File(location + fileName);	
			if(file.exists()) {
				if(file.delete()) {
					System.out.println("파일삭제 성공");
				}else {
					System.out.println("파이삭제 실패");
					
				}
			}else {
				System.err.println("파일이 존재하지 아늡니다.");
			}
			
			imgService.imgDeleteOne(bno, fileName);
		
			return "redirect:/board/read?bno="+bno;
		
		
	}
	
	//insertImage
	@RequestMapping(value = "/insertImage")
	public String insertImage(int bno,List<MultipartFile> file)throws Exception{
		for (int i = 0; i < file.size(); i++) {
			System.out.println(file.get(i).getOriginalFilename());
			// file 이름 만들기.
			UUID uid = UUID.randomUUID();

			String fileName = file.get(i).getOriginalFilename();
			String uploadName = uid + "_" + fileName;

			String datePath = UploadFileUtils.calcPath("C:\\TEMP\\");

			System.out.println("test !@# : " + datePath);

			FileOutputStream fos = new FileOutputStream("C:\\TEMP\\" + datePath + File.separator + uploadName);

			IOUtils.copy(file.get(i).getInputStream(), fos);

			ImgVO ivo = new ImgVO();
			ivo.setFileName(uploadName);
			ivo.setLocation("C:\\TEMP\\" + datePath + File.separator);

			System.out.println(" name  : " + ivo.getFileName() + "  lo   : " + ivo.getLocation());

			imgService.create(ivo);
			fos.close();
		}
		
			return "redirect:/board/read?bno="+bno;
		
	}
	

	
}
