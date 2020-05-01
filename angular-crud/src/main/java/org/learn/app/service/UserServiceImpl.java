package org.learn.app.service;

import org.learn.app.daoImpl.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDAOImpl userDAOImpl;

	// 
}
