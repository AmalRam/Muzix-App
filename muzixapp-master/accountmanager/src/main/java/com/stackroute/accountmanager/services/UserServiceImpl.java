package com.stackroute.accountmanager.services;

import java.util.Optional;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.accountmanager.domain.User;
import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	

	private final transient UserRepository userRepo;

	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException, UserNotFoundException {
		Optional<User> usr = userRepo.findById(user.getUserId());
		if (usr.isPresent()) {
			throw new UserAlreadyExistsException("User with Id already exists");
		}
		userRepo.save(user);
		return true;
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUserIdAndPassword(userId, password);
		if(user==null)
		{
			throw new UserNotFoundException("UserId and Password mismatch");
		}
		return user;
	}

	
	@Override
	public User updateUser(User user,String userId) throws UserNotFoundException {
		try {
		Optional<User> user1= userRepo.findById(userId);
			if(user1.isPresent()) {	
				user1.get().setFirstName(user.getFirstName());
				user1.get().setLastName(user.getLastName());  
				user1.get().setPassword(user.getPassword());
		    	user1.get().setCreated(user1.get().getCreated());
				User user2=user1.get();
				userRepo.save(user2);
				
				return user2;
			}
			else
			{
				return null;
			}
			
	   }catch(Exception e) {
		e.printStackTrace();
		throw e;
	  }
		
	}
	
	@Override
	public User viewUser(String userId) throws UserNotFoundException {
		try {
		Optional<User> user1= userRepo.findById(userId);
			if(user1.isPresent()) {	
				User user2=user1.get();
				return user2;
			}
			else
			{
				return null;
			}
			
	   }catch(Exception e) {
		e.printStackTrace();
		throw e;
	  }
		
	}
	
	
}


