package org.spring.img.persistence;

import java.util.List;

import org.spring.img.domain.BoardVO;
import org.spring.img.domain.Criteria;
import org.spring.img.domain.Paging;

public interface BoardDAO {

	public void create(BoardVO vo)throws Exception;
	public BoardVO read(int bno)throws Exception;
	public void update(BoardVO vo)throws Exception;
	public void delete(int bno)throws Exception;
	public List<BoardVO> list(Criteria cri)throws Exception;
	public int listCount()throws Exception;
}
