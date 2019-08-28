package org.spring.img.service;

import org.spring.img.domain.BoardVO;

public interface BoardService {
	public void create(BoardVO vo)throws Exception;
	public BoardVO read(int bno)throws Exception;
	public void update(BoardVO vo)throws Exception;
	public void delete(int bno)throws Exception;
}
