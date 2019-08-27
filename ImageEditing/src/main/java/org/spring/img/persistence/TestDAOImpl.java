package org.spring.img.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class TestDAOImpl {
	
	@Inject
	private SqlSession session;
	
	public String time() throws Exception{
		return session.selectOne("org.spring.img.mappers.testMapper.getTime");
		
	}

}
