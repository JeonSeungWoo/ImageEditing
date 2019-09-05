package org.spring.img.service;

import javax.inject.Inject;

import org.spring.img.domain.UserVO;
import org.spring.img.persistence.UserDAO;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO login(UserVO dto) {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}

	@Override
	public void loginCreate(UserVO vo) throws Exception {
	    dao.loginCreate(vo);
		
	}

	@Override
	public Integer checkId(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkId(vo);
	}

	@Override
	public UserVO userInfo(String userId) throws Exception {
		// TODO Auto-generated method stub
		return dao.userInfo(userId);
	}

	@Override
	public void userUpdate(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.userUpdate(vo);
	}

}
