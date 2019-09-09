package org.spring.img.service;

import javax.inject.Inject;

import org.spring.img.domain.ImgVO;
import org.spring.img.persistence.EdtBAO;
import org.springframework.stereotype.Service;

@Service
public class EditServiceImpl implements EditService {

	@Inject
	private EdtBAO dao;

	@Override
	public ImgVO edtUI(int ino) throws Exception {
		// TODO Auto-generated method stub
		return dao.edtUI(ino);
	}

}
