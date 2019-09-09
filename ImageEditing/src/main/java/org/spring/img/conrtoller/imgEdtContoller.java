package org.spring.img.conrtoller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.img.domain.ImgVO;
import org.spring.img.domain.UserVO;
import org.spring.img.service.EditService;
import org.spring.img.util.UploadFileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/edt/*")
@Controller
public class imgEdtContoller {

	private static final Logger logger = LoggerFactory.getLogger(imgEdtContoller.class);


	@Inject
	private EditService service;
	
	
	@RequestMapping(value = "/edtUi", method = RequestMethod.GET)
	public void edtUi(Model model, UserVO vo, HttpSession session,@RequestParam("ino") int ino) throws Exception {
		
		System.out.println(service.edtUI(ino));
		
		model.addAttribute("img",service.edtUI(ino));
	}

	
	
	
	
	// 대표이미지 보여주기
		@SuppressWarnings("unused")
		@RequestMapping(value = "/edtShow")
		public @ResponseBody byte[] edtShow(Model model, UserVO vo, HttpSession session,@RequestParam("ino") int ino) throws Exception {
      
			System.out.println("dkdk   :  "  + ino);
			
			InputStream in;
			String location = "";
			String fileName = "";
			String noImg = "C:\\TEMP\\noImage.png";
			if (service.edtUI(ino) != null) {
				location =service.edtUI(ino).getLocation();
				fileName = service.edtUI(ino).getFileName();
				in = new FileInputStream(location + fileName);
			} else {
				in = new FileInputStream(noImg);

			}
			byte[] result = IOUtils.toByteArray(in);
			in.close();
			return result;

		}

	
	
	
	
	
	
	
	
}
