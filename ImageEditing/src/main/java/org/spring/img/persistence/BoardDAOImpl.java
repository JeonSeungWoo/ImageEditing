package org.spring.img.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.img.domain.BoardVO;
import org.spring.img.domain.Criteria;
import org.spring.img.domain.Paging;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private String name = "org.spring.img.mappers.boardMapper.";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(name+"create", vo);

	}

	@Override
	public BoardVO read(int bno) throws Exception {
		
		return session.selectOne(name + "read",bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(name + "update",vo);

	}

	@Override
	public void delete(int bno) throws Exception {
		session.delete(name + "delete",bno);
	}

	@Override
	public List<BoardVO> list(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(name + "list",cri);
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(name + "listCount");
	}

	@Override
	public List<BoardVO> userlist(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(name + "userlist", cri);
	}

	@Override
	public int userlistCount() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(name + "userlistCount");
	}

}
