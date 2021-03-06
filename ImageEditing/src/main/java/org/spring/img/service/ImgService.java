package org.spring.img.service;

import java.util.List;

import org.spring.img.domain.BoardVO;
import org.spring.img.domain.ImgVO;
import org.springframework.web.multipart.MultipartFile;

public interface ImgService {
	public void imgInsertOne(ImgVO vo)throws Exception;
	public ImgVO imgReadPage(int bno)throws Exception;
	public List<ImgVO> imgList(int bno)throws Exception;
	public ImgVO imgReadAll(int bno,String fileName)throws Exception;
	public void imgDeleteOne(int bno,String fileName)throws Exception;

}
