package com.stackroute.accountmanager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.After;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.accountmanager.domain.User;
import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.repositories.UserRepository;
import com.stackroute.accountmanager.services.UserService;
import com.stackroute.accountmanager.services.UserServiceImpl;

public class UserServiceTest {
	@Mock
	private UserRepository repository;
	@InjectMocks
	private UserServiceImpl service;
	@Autowired
	private MockMvc mockMvc;
	private User user1= Mockito.mock(User.class);
	private User user2= Mockito.mock(User.class);
	transient Optional<User> optUser;
	// initializing mock objects
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(service).build();
		user1 = new User("raman1", "raman1", "raman1", "raman1",new Date());
	}
	
	// test for add User
	@Test
	 public void addUserTest_Success() throws UserAlreadyExistsException, UserNotFoundException  { 
		
		when(repository.save(user1)).thenReturn(user1);
	    final Boolean flag= service.saveUser(user1);
		Assert.assertTrue(flag);
	}
	// test for is user present with specific emailId and password
	@Test
	 public void isUsernameAndPasswordPresentTest_Success() throws UserNotFoundException  {
		when(this.repository.findByUserIdAndPassword(this.user1.getUserId(), this.user1.getPassword()))
				.thenReturn(user1);
		this.service.findByUserIdAndPassword(this.user1.getUserId(), this.user1.getPassword());
		Assert.assertEquals(user1, this.service.findByUserIdAndPassword(this.user1.getUserId(), this.user1.getPassword()));
	}

	@Test(expected = UserAlreadyExistsException.class)
	 public void addUserTest_Failure() throws UserAlreadyExistsException, UserNotFoundException  { 
		 user2 = new User("test30", "test30", "test30", "test30", new Date());
	    	optUser = Optional.of(user2);
			when(repository.findById(Mockito.anyString())).
				thenReturn(optUser);
			final boolean result = service.saveUser(user2);
			Assert.assertEquals(result,false);
			verify(repository).findById(Mockito.anyString());
	}
	// test for is user present with specific emailId and password
	@Test(expected=UserNotFoundException.class)
	 public void isUsernameAndPasswordInvalidTest() throws UserNotFoundException  {
	
		when(this.repository.save(user1)).thenReturn(user1);
		Assert.assertNotEquals(user1,this.service.findByUserIdAndPassword("reddy11","reddy11"));
	}
}
