package org.spring.img.service;

import java.util.List;

import javax.inject.Inject;

import org.spring.img.domain.BoardVO;
import org.spring.img.domain.Criteria;
import org.spring.img.persistence.BoardDAO;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	
	
	@Inject
	private BoardDAO dao;

	@Override
	public void create(BoardVO vo) throws Exception {
		dao.create(vo);
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
		// TODO Auto-generated method stub
		return dao.list(cri);
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount();
	}

}
