package com.dmt.service;

import com.dmt.dao.ManagerDao;
import com.dmt.model.Manager;

public class ManagerService {

	public void addNewManager(String username, String password, String fullName, String email, String phoneNumber,
			String address) throws Exception {
		ManagerDao dao = new ManagerDao();
		dao.addNewManager(username, password, fullName, email, phoneNumber, address);
	}

	public Manager login(String username, String password) throws Exception {
		ManagerDao dao = new ManagerDao();
		return dao.login(username, password);
	}

}
