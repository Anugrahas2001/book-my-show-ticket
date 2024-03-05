package com.demo.myticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.myticket.dao.UserDao;
import com.demo.myticket.dto.ResponseStructure;
import com.demo.myticket.entity.UserInfo;
import com.demo.myticketexception.IdNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<UserInfo>> saveUser(UserInfo user) {
		
		UserInfo users=userDao.saveUser(user);
		ResponseStructure<UserInfo> responsestructure=new ResponseStructure<UserInfo>();
		responsestructure.setStatusCode(HttpStatus.CREATED.value());
		responsestructure.setMessage("User Created");
		responsestructure.setData(users);
		return new ResponseEntity<ResponseStructure<UserInfo>>(responsestructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<UserInfo>> getUser(int userId) {
		UserInfo users=userDao.getUser(userId);
		
		if(users !=null)
		{
			ResponseStructure<UserInfo> responsestructure=new ResponseStructure<UserInfo>();
			responsestructure.setStatusCode(HttpStatus.FOUND.value());
			responsestructure.setMessage("User data retrived");
			responsestructure.setData(users);
			return new ResponseEntity<ResponseStructure<UserInfo>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}

}
