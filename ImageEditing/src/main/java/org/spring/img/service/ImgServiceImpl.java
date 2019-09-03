package org.spring.img.service;

import java.util.List;

import javax.inject.Inject;

import org.spring.img.domain.ImgVO;
import org.spring.img.persistence.ImgDAO;
import org.springframework.stereotype.Service;

@Service
public class ImgServiceImpl implements ImgService{
	
	@Inject
	private ImgDAO dao;
	
	
	@Override
	public ImgVO imgReadPage(int bno) throws Exception {
		return dao.imgReadPage(bno);
	}

	@Override
	public List<ImgVO> imgList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.imgList(bno);
	}

	@Override
	public ImgVO imgReadAll(int bno, String fileName) throws Exception {
		// TODO Auto-generated method stub
		return dao.imgReadAll(bno, fileName);
	}

	@Override
	public void imgDeleteOne(int bno, String fileName) throws Exception {
	      dao.imgDeleteOne(bno, fileName);
		
	}

	@Override
	public void create(ImgVO vo) throws Exception {
		dao.create(vo);
		
	}

	
}
