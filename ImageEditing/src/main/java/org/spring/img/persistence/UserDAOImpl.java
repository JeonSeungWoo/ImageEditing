package org.spring.img.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.img.domain.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{

	
	@Inject
	SqlSession session;
	
	
	@Override
	public UserVO login(UserVO dto) {
		// TODO Auto-generated method stub
		return session.selectOne("org.spring.img.mappers.userMapper.login",dto);
	}


	@Override
	public void loginCreate(UserVO vo) throws Exception {
		session.insert("org.spring.img.mappers.userMapper.loginCreate",vo);
		
	}


	@Override
	public Integer checkId(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("org.spring.img.mappers.userMapper.checkId",vo);
	}

	
	
	
}
