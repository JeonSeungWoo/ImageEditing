package org.spring.img.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.spring.img.domain.BoardVO;
import org.spring.img.domain.Criteria;
import org.spring.img.domain.ImgVO;
import org.spring.img.persistence.BoardDAO;
import org.spring.img.persistence.ImgDAO;
import org.spring.img.util.MediaUtils;
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
	public void create(BoardVO vo, List<MultipartFile> file) throws Exception {
		// 이미지를 추가.

		dao.create(vo);

		for (int i = 0; i < file.size(); i++) {
			// file 이름 만들기.
			UUID uid = UUID.randomUUID();

			String fileName = file.get(i).getOriginalFilename();
			
			// 이미지 파일 체크!!!
			String extension = FilenameUtils.getExtension(fileName);
			
			if (extension.equals("jpg") || extension.equals("png") || 
				extension.equals("gif") || extension.equals("JPG") || 
				extension.equals("PNG") || extension.equals("GIF") || 
				extension.equals("jpeg") || extension.equals("JPEG") )
			{
				
				String uploadName = uid + "_" + fileName;

				String datePath = UploadFileUtils.calcPath("C:\\TEMP\\");


				FileOutputStream fos = new FileOutputStream("C:\\TEMP\\" + datePath + File.separator + uploadName);

				IOUtils.copy(file.get(i).getInputStream(), fos);

				ImgVO ivo = new ImgVO();
				ivo.setFileName(uploadName);
				ivo.setLocation("C:\\TEMP\\" + datePath + File.separator);

				idao.create(ivo);
				fos.close();
			}else {
				
			}
			
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

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		List<ImgVO> list = idao.imgList(bno);
		System.out.println("imgList  ::  " + idao.imgList(bno));
        String location = "";
		String fileName = "";
		
		//for문 스타트
		for (int i = 0; i < list.size(); i++) {
		location = list.get(i).getLocation();
		fileName = list.get(i).getFileName();
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
		
		}
		idao.imgDelete(bno);
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

	@Override
	public List<BoardVO> userlist(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.userlist(cri);
	}

	@Override
	public int userlistCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.userlistCount();
	}

}
