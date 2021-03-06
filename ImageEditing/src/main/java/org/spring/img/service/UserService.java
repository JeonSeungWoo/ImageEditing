package org.spring.img.service;

import org.spring.img.domain.UserVO;

public interface UserService {
	public UserVO login(UserVO dto);

	public void loginCreate(UserVO vo) throws Exception;

	public Integer checkId(UserVO vo) throws Exception;

	public UserVO userInfo(String userId) throws Exception;

	public void userUpdate(UserVO vo) throws Exception;
}
