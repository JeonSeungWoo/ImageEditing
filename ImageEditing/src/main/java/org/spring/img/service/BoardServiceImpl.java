package org.spring.img.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.spring.img.domain.BoardVO;
import org.spring.img.domain.Criteria;
import org.spring.img.domain.ImgVO;
import org.spring.img.persistence.BoardDAO;
import org.spring.img.persistence.ImgDAO;
import org.spring.img.util.UploadFileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardServiceImpl implements BoardService {
	
	
	
	@Inject
	private BoardDAO dao;
	
	@Inject
    private ImgDAO idao;
	
	
	@Transactional
	@Override
	public void create(BoardVO vo,List<MultipartFile> file) throws Exception {
		//이미지를 추가.
		
		dao.create(vo);
		
		
		
		for (int i = 0; i < file.size(); i++) {
			System.out.println(file.get(i).getOriginalFilename());
			//file 이름 만들기.
			UUID uid = UUID.randomUUID();
			
			String fileName =  file.get(i).getOriginalFilename();
			String uploadName = uid + "_" + fileName;
			
			String datePath = UploadFileUtils.calcPath("C:\\TEMP\\");
			
			System.out.println("test !@# : " + datePath);
			
			FileOutputStream fos = new FileOutputStream("C:\\TEMP\\" + datePath + File.separator + uploadName);
			
			IOUtils.copy(file.get(i).getInputStream(), fos);
			
			ImgVO ivo = new ImgVO();
			ivo.setFileName(uploadName);
			ivo.setLocation("C:\\TEMP\\" + datePath + File.separator);
			
			System.out.println(" name  : " + ivo.getFileName()  +"  lo   : " + ivo.getLocation());
			
			idao.create(ivo);
			fos.close();
		}
		
		
		
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);

	}

	@Override
	public List<BoardVO> list(Criteria cri) throws Exception {
		
		
		return dao.list(cri);
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount();
	}

}
