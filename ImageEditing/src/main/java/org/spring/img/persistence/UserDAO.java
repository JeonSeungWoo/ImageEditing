package org.spring.img.persistence;

import org.spring.img.domain.UserVO;

public interface UserDAO {
   public UserVO login(UserVO dto);
   public void loginCreate(UserVO vo)throws Exception;
   public Integer checkId(UserVO vo)throws Exception;   
}
