package org.spring.img.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.img.persistence.TestDAOImpl;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Service
public class TestService {
  
	@Inject
	private TestDAOImpl dao;
	
	
	@Test
	public void test()throws Exception{
		System.out.println(dao.time());
		
	}
	
	
}
