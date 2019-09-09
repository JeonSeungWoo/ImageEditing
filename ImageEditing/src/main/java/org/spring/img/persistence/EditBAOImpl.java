package org.spring.img.persistence;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.spring.img.domain.ImgVO;
import org.springframework.stereotype.Repository;


@Repository
public class EditBAOImpl implements EdtBAO{

	@Inject
	private SqlSession session;
	
	
	@Override
	public ImgVO edtUI(int ino) throws Exception {
		return session.selectOne("org.spring.img.mappers.edtMapper.edtUi",ino);
	}

}
