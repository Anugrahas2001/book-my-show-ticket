package com.demo.myticket.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.myticket.entity.UserInfo;
import com.demo.myticket.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public UserInfo saveUser(UserInfo user) {
		return userRepository.save(user);
	}

	public UserInfo getUser(int userId) {
		Optional<UserInfo> optional = userRepository.findById(userId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

}
