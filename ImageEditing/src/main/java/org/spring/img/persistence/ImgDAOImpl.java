package org.spring.img.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.img.domain.ImgVO;
import org.springframework.stereotype.Repository;

@Repository
public class ImgDAOImpl implements ImgDAO{

	@Inject
	private SqlSession session;

	private String name = "org.spring.img.mappers.imgMapper.";
	
	@Override
	public void create(ImgVO vo) throws Exception {
		
		System.out.println("VO : " + vo.getBno() + vo.getFileName() + vo.getLocation());
		session.insert(name + "imgInsert", vo);
		
	}

	@Override
	public ImgVO imgReadPage(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(name + "imgReadPage",bno);
	}

	@Override
	public List<ImgVO> imgList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(name + "imgList" ,bno);
	}

	@Override
	public ImgVO imgReadAll(int bno, String fileName) throws Exception {
		
		HashMap<String, String> map = new HashMap<String, String>();		
		map.put("bno", Integer.toString(bno));
		map.put("fileName", fileName);
		
		return session.selectOne(name + "imgReadAll" ,map);
	}

}
